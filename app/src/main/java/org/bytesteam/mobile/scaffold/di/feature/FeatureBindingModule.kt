package org.bytesteam.mobile.scaffold.di.feature

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.bytesteam.mobile.scaffold.DashboardActivity
import org.bytesteam.mobile.scaffold.module.splash.SplashActivity

@Module()
abstract class FeatureBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeDashboardActivity(): DashboardActivity
}