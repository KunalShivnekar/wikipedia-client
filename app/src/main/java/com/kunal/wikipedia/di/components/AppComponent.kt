package com.kunal.wikipedia.di.components

import com.kunal.wikipedia.config.WikipediaApplication
import com.kunal.wikipedia.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by kunal.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }

    val dataComponentBuilder: DataComponent.Builder

    fun inject(wikipediaApplication: WikipediaApplication)
}