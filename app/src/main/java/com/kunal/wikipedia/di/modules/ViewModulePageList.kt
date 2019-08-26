package com.kunal.wikipedia.di.modules

import com.kunal.wikipedia.view.pagelist.PageListContract
import com.kunal.wikipedia.view.pagelist.PageListPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module
class ViewModulePageList {

    @Provides
    fun getPageListPresenter(pageListPresenter: PageListPresenter):PageListContract.Presenter = pageListPresenter
}