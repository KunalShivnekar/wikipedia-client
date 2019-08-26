package com.kunal.wikipedia.view.pagelist

import com.kunal.wikipedia.view.base.BasePresenter
import com.kunal.wikipedia.view.base.BaseView
import com.kunal.wikipedia.view.pagelist.model.Page

/**
 * Created by kunal.
 */
interface PageListContract {

    interface View:BaseView<Presenter>{
        fun setData(list:List<Page>)
    }

    interface Presenter:BasePresenter<View>{
        fun search(text:String)
    }
}