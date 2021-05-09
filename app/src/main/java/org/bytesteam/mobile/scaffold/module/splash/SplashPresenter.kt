package org.bytesteam.mobile.scaffold.module.splash

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.bytesteam.mobile.scaffold.base.BasePresenter

class SplashPresenter : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun start() {
        mainScope.launch {
            delay(300)
            view?.enterDashboard()
        }
    }
}