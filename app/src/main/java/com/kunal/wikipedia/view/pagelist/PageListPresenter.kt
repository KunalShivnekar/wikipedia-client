package com.kunal.wikipedia.view.pagelist

import com.kunal.wikipedia.data.base.DataSource.GetItemsCallback
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.RemoteDataSource
import com.kunal.wikipedia.view.base.BasePresenterImpl
import com.kunal.wikipedia.view.pagelist.model.Page
import javax.inject.Inject

/**
 * Created by kunal.
 */
class PageListPresenter @Inject constructor(private val remoteDataSource: RemoteDataSource): BasePresenterImpl<PageListContract.View>(), PageListContract.Presenter{

    override fun search(text:String) {
        view?.showLoader()
        remoteDataSource.getItems(text, object : GetItemsCallback<Page> {
            override fun onFailure(response: Response) {
                view?.showError(response.description)
                view?.hideLoader()
            }

            override fun onSuccess(data: List<Page>) {
                view?.setData(data)
                view?.hideLoader()
            }
        })
    }
}