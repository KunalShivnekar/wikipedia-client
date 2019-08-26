package com.kunal.wikipedia.network.http

/**
 * Created by kunal.
 */
interface HttpClient {

    interface ResponseCallback {

        fun onSuccess(httpResponse: HttpResponse)

        fun onFailure(httpResponse: HttpResponse)
    }
    val bodyContentTypeJson: String

    fun get(request: HttpRequest, callback: ResponseCallback)

}