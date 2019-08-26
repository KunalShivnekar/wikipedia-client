package com.kunal.wikipedia.view.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by kunal.
 */
interface BasePresenter<T>:LifecycleObserver {

     fun attachView(view: T, lifecycleOwner: LifecycleOwner)

    /**
     * Use this method to detach the presenter from the view it is attached to.
     */
     fun detachView()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Event.ON_CREATE)
     fun onCreate()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
     fun onPause()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
     fun onResume()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
     fun onStart()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
     fun onStop()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Event.ON_DESTROY)
     fun onDestroy()
}