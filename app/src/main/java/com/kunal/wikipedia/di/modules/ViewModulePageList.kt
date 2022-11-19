package com.kunal.wikipedia.di.modules

import com.kunal.wikipedia.view.pagelist.PageListViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module
class ViewModulePageList {

    @Provides
    fun getPageListViewModel(pageListViewModel: PageListViewModel):PageListViewModel = pageListViewModel
}