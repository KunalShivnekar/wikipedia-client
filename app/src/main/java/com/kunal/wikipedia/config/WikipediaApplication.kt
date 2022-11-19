package com.kunal.wikipedia.config

import android.app.Application
import com.kunal.wikipedia.di.components.AppComponent
import com.kunal.wikipedia.di.components.DaggerAppComponent
import com.kunal.wikipedia.di.components.DataComponent

/**
 * Created by kunal.
 */

class WikipediaApplication : Application() {

    lateinit var appComponent:AppComponent

    lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

        appComponent.inject(this)

        dataComponent = appComponent.dataComponentBuilder.build()
    }
}