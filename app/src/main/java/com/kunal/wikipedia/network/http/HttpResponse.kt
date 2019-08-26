package com.kunal.wikipedia.network.http

/**
 * Created by kunal.
 */
data class HttpResponse(val code:Int, val body:String){

    var exception:Exception? = null

    constructor(exception: Exception):this(0,""){
        this.exception = exception
    }
}