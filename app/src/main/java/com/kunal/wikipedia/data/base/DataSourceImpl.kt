package com.kunal.wikipedia.data.base

import com.kunal.wikipedia.data.base.DataSource.GetItemsCallback

/**
 * Created by kunal.
 */
 abstract class DataSourceImpl<T>:DataSource<T> {

    override fun getItems(getItemsCallback: GetItemsCallback<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}