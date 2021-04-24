package org.bytesteam.mobile.scaffold.di

import android.content.Context
import dagger.Module
import dagger.Provides
import org.bytesteam.mobile.scaffold.App
import org.bytesteam.mobile.scaffold.di.annotation.AppContext
import org.bytesteam.mobile.scaffold.di.feature.FeatureModule
import javax.inject.Singleton

@Module(
    includes = [
        FeatureModule::class
    ]
)
class AppModule {

    @AppContext
    @Singleton
    @Provides
    fun provideAppContext(app: App): Context {
        return app.applicationContext
    }
}