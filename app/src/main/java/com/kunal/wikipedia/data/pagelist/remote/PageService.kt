package com.kunal.wikipedia.data.pagelist.remote

import com.kunal.wikipedia.data.pagelist.model.PageApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PageService {

    @GET("https://en.wikipedia.org//w/api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description")
    suspend fun getPageList(@Query("gpssearch") query:String): Response<PageApiResponse>
}