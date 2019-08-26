package com.kunal.wikipedia.view.criteria

import com.kunal.wikipedia.view.base.BasePresenter
import com.kunal.wikipedia.view.base.BaseView

/**
 * Created by kunal on 2019-08-04.
 */
interface CriteriaContract {

    interface View: BaseView<Presenter> {

    }

    interface Presenter: BasePresenter<View>
}