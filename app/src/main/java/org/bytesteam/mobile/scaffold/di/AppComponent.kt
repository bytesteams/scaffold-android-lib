package org.bytesteam.mobile.scaffold.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import org.bytesteam.mobile.scaffold.App
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppBindingModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}