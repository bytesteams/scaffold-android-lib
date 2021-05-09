package org.bytesteam.mobile.scaffold.base

import android.os.Bundle
import dagger.android.DaggerActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.bytesteam.mobile.scaffold.R

abstract class BaseActivity : DaggerActivity(), MVPContract.View {

    protected val mainScope: CoroutineScope by lazy { MainScope() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        window.setWindowAnimations(R.style.ActivityFadeInFadeOutAnimation)
    }

    override fun showLogon() {
    }

    override fun showError(message: String) {
    }

    override fun hideError() {
    }

    abstract fun getLayoutId(): Int
}