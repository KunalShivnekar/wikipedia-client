package com.kunal.wikipedia.di.modules

import com.kunal.wikipedia.data.pagelist.RemoteDataSource
import com.kunal.wikipedia.data.pagelist.RemoteDataSourceImpl
import com.kunal.wikipedia.di.components.ViewComponent
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module(subcomponents = [ViewComponent::class])
class DataModule {

    @Provides
    fun getRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource = remoteDataSourceImpl
}