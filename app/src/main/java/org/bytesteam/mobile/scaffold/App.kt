package org.bytesteam.mobile.scaffold

import android.app.Application
import org.bytesteam.mobile.scaffold.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build()
    }
}