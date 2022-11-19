package com.kunal.wikipedia.view.base

import androidx.lifecycle.LifecycleObserver

/**
 * Created by kunal.
 */
interface BaseView{

    /**
     * Use this method to hide progress bar on the view
     */
    fun hideLoader()

    /**
     * This method shows error message on the view.
     *
     * @param  error string to show
     */
    fun showError(error:String)

    /**
     * Use this method to show progress bar on the view
     */
    fun showLoader()
}