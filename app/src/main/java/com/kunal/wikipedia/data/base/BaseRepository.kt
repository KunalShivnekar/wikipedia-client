package com.kunal.wikipedia.data.base

interface BaseRepository<T> {

    suspend fun getItems(query:String):Response<T>
}