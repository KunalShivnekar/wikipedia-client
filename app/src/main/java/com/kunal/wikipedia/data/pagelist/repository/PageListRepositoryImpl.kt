package com.kunal.wikipedia.data.pagelist.repository

import com.kunal.wikipedia.data.base.BaseRepositoryImpl
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.data.pagelist.model.Page
import com.kunal.wikipedia.data.pagelist.remote.RemoteDataSource
import javax.inject.Inject

class PageListRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):BaseRepositoryImpl<List<Page>>(),PageListRepository {

    override suspend fun getItems(query: String): Response<List<Page>> {
        return remoteDataSource.getItems(query)
    }
}