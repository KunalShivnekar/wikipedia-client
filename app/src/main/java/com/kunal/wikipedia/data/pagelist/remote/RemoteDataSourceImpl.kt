package com.kunal.wikipedia.data.pagelist.remote

import com.kunal.wikipedia.data.base.BaseDataSourceImpl
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.model.Page
import javax.inject.Inject

/**
 * Created by kunal.
 */
class RemoteDataSourceImpl @Inject constructor(private val pageService: PageService) : BaseDataSourceImpl<List<Page>>(), RemoteDataSource {

    override suspend fun getItems(query: String): Response<List<Page>> {
        val apiResponse =  pageService.getPageList(query)
        return apiResponse.body()?.query?.let { Response.Success(it.pages) }!!
    }
}