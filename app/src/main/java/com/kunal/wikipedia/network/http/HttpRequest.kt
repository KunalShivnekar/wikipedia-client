package com.kunal.wikipedia.network.http

/**
 * Created by kunal.
 */
data class HttpRequest(val endpointUrl:String) {

    var headers:Map<String,String> = HashMap()

    constructor(endpointUrl:String, headers:Map<String,String>):this(endpointUrl){
        this.headers = headers
    }
}