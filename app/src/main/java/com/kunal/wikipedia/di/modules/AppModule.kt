package com.kunal.wikipedia.di.modules

import com.google.gson.Gson
import com.kunal.wikipedia.di.components.DataComponent
import com.kunal.wikipedia.network.http.HttpClient
import com.kunal.wikipedia.network.http.HttpClientImpl
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module(subcomponents = [DataComponent::class])
class AppModule {

    @Provides
    fun getHttpApiClient(httpClientImpl: HttpClientImpl): HttpClient = httpClientImpl

    @Provides
    fun getGson(): Gson = Gson()
}