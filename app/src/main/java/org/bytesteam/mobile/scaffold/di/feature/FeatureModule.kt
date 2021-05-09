package org.bytesteam.mobile.scaffold.di.feature

import dagger.Module
import dagger.Provides
import org.bytesteam.mobile.scaffold.module.splash.SplashContract
import org.bytesteam.mobile.scaffold.module.splash.SplashPresenter
import javax.inject.Singleton

@Module
class FeatureModule {

    @Singleton
    @Provides
    fun provideSplashPresenter(): SplashContract.Presenter {
        return SplashPresenter()
    }
}