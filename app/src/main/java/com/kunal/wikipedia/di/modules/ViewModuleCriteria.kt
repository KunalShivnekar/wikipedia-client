package com.kunal.wikipedia.di.modules

import com.kunal.wikipedia.view.criteria.CriteriaContract
import com.kunal.wikipedia.view.criteria.CriteriaPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by kunal.
 */
@Module
class ViewModuleCriteria {

    @Provides
    fun getCriteriaPresenter(criteriaPresenter: CriteriaPresenter): CriteriaContract.Presenter = criteriaPresenter
}