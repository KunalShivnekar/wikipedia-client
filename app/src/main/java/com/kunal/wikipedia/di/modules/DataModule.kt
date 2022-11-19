package com.kunal.wikipedia.di.modules

import com.kunal.wikipedia.data.pagelist.remote.RemoteDataSource
import com.kunal.wikipedia.data.pagelist.remote.RemoteDataSourceImpl
import com.kunal.wikipedia.data.pagelist.repository.PageListRepository
import com.kunal.wikipedia.data.pagelist.repository.PageListRepositoryImpl
import com.kunal.wikipedia.di.components.ViewComponent
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module(subcomponents = [ViewComponent::class])
class DataModule {

    @Provides
    fun getRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource = remoteDataSourceImpl

    @Provides
    fun getPageListRepository(pageListRepositoryImpl: PageListRepositoryImpl): PageListRepository = pageListRepositoryImpl
}