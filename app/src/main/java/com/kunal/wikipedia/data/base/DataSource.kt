package com.kunal.wikipedia.data.base

/**
 * Created by kunal.
 */
interface DataSource<T> {

    interface GetItemsCallback<T> {

        fun onFailure(response: Response)

        fun onSuccess(data: List<T>)
    }

    fun getItems(query:String, getItemsCallback: GetItemsCallback<T>)
}