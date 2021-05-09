package org.bytesteam.mobile.scaffold.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

abstract class BaseFragment : DaggerFragment(), MVPContract.View {

    protected val mainScope: CoroutineScope by lazy { MainScope() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    abstract fun getLayoutId(): Int

    override fun showLogon() {
    }

    override fun showError(message: String) {
    }

    override fun hideError() {
    }
}