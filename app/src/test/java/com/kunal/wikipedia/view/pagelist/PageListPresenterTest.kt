package com.kunal.wikipedia.view.pagelist

import com.kunal.wikipedia.base.BaseUnitTest
import com.kunal.wikipedia.data.base.DataSource.GetItemsCallback
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.RemoteDataSource
import com.kunal.wikipedia.view.pagelist.model.Page
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.*

/**
 * Created by kunal on 2019-07-28.
 */
class PageListPresenterTest : BaseUnitTest(){

    @MockK
    private lateinit var pageListPresenter: PageListPresenter

    @MockK
    private lateinit var remoteDataSource: RemoteDataSource

    @MockK
    private lateinit var view: PageListContract.View

    override fun setup(){
        super.setup()
        MockKAnnotations.init(this)
        pageListPresenter = PageListPresenter(remoteDataSource)
        pageListPresenter.attachView(view, lifecycleOwner)

        every { view.showLoader() } just Runs
        every { view.hideLoader() } just Runs
        every { view.setData(any()) } just Runs
        every { view.showError(any()) } just Runs
    }

    @Test
    fun `on Start - remoteDataSource success `() {
        val callbackSlot = slot<GetItemsCallback<Page>>()
        val mockData  =ArrayList<Page>()
        every { remoteDataSource.getItems(capture(callbackSlot)) } answers {
            callbackSlot.captured.onSuccess(mockData)
        }

        pageListPresenter.onStart()

        verify(exactly = 1) { view.showLoader() }
        verify(exactly = 1) { remoteDataSource.getItems(eq(callbackSlot.captured)) }
        verify { view.setData(mockData) }
        verify { view.hideLoader() }
    }

    @Test
    fun `on Start - remoteDataSource failure `() {
        val callbackSlot = slot<GetItemsCallback<Page>>()
        val mockData  = Response("Error")
        every { remoteDataSource.getItems(capture(callbackSlot)) } answers {
            callbackSlot.captured.onFailure(mockData)
        }

        pageListPresenter.onStart()

        verify(exactly = 1) { view.showLoader() }
        verify(exactly = 1) { remoteDataSource.getItems(eq(callbackSlot.captured)) }
        verify { view.showError(mockData.description) }
        verify { view.hideLoader() }
    }
}