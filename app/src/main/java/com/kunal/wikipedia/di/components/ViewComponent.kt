package com.kunal.wikipedia.di.components

import com.kunal.wikipedia.di.modules.ViewModuleCriteria
import com.kunal.wikipedia.di.modules.ViewModulePageList
import com.kunal.wikipedia.view.criteria.CriteriaFragment
import com.kunal.wikipedia.view.pagelist.PageListFragment
import dagger.Subcomponent

/**
 * Created by kunal.
 */
@Subcomponent(modules = [ViewModuleCriteria::class, ViewModulePageList::class])
interface ViewComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): ViewComponent
    }

    fun inject(pageListFragment: PageListFragment)

    fun inject(criteriaFragment: CriteriaFragment)
}