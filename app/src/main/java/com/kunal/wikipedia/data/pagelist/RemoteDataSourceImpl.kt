package com.kunal.wikipedia.data.pagelist

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kunal.wikipedia.data.base.DataSource.GetItemsCallback
import com.kunal.wikipedia.data.base.DataSourceImpl
import com.kunal.wikipedia.data.base.Response
import com.kunal.wikipedia.network.http.HttpClient
import com.kunal.wikipedia.network.http.HttpClient.ResponseCallback
import com.kunal.wikipedia.network.http.HttpRequest
import com.kunal.wikipedia.network.http.HttpResponse
import com.kunal.wikipedia.view.pagelist.model.Page
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

/**
 * Created by kunal.
 */
class RemoteDataSourceImpl @Inject constructor(private val httpClient: HttpClient, private val gson: Gson) : DataSourceImpl<Page>(), RemoteDataSource {

    private val endPointURL:String = "https://en.wikipedia.org//w/api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description&gpssearch="

    override fun getItems(query:String,getItemsCallback: GetItemsCallback<Page>) {
        val request = HttpRequest("$endPointURL$query&gpslimit=10")
        httpClient.get(request = request, callback = object : ResponseCallback {
            override fun onSuccess(httpResponse: HttpResponse) {
                val jsonResponse =  JSONObject(httpResponse.body).getJSONObject("query").getJSONArray("pages").toString()
                val listType = object : TypeToken<List<Page>>() {}.type
                getItemsCallback.onSuccess(gson.fromJson<List<Page>>(jsonResponse, listType))
            }

            override fun onFailure(httpResponse: HttpResponse) {
                getItemsCallback.onFailure(if (httpResponse.exception is IOException){
                    Response("Network Error")
                } else {
                    Response("Server Error")
                })
            }
        })
    }
}