package org.bytesteam.mobile.scaffold.module.splash

import org.bytesteam.mobile.scaffold.base.MVPContract

interface SplashContract {

    interface View : MVPContract.View {
        fun enterDashboard()
    }

    interface Presenter : MVPContract.Presenter<View> {
        fun start()
    }
}