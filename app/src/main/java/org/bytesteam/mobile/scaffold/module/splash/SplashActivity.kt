package org.bytesteam.mobile.scaffold.module.splash

import android.os.Bundle
import org.bytesteam.mobile.scaffold.DashboardActivity
import org.bytesteam.mobile.scaffold.R
import org.bytesteam.mobile.scaffold.base.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun enterDashboard() {
        DashboardActivity.start(this)
        finish()
    }
}