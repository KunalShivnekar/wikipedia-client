package com.kunal.wikipedia.di.components

import com.kunal.wikipedia.di.modules.DataModule
import dagger.Subcomponent

/**
 * Created by kunal.
 */
@Subcomponent(modules = [DataModule::class])
interface DataComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): DataComponent

    }

    val viewComponentBuilder: ViewComponent.Builder
}