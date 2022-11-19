package com.kunal.wikipedia.data.base

import androidx.lifecycle.LiveData

/**
 * Created by kunal.
 */
interface BaseDataSource<T> {

    suspend fun getItems(query:String):Response<T>
}