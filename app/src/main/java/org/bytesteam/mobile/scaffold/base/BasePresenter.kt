package org.bytesteam.mobile.scaffold.base

import androidx.annotation.CallSuper

class BasePresenter<T : MVPContract.View> : MVPContract.Presenter<T> {

    var view: T? = null

    @CallSuper
    fun attachView(view: T) {
        this.view = view
    }

    @CallSuper
    fun detachView() {
        this.view = null
    }

    override fun onError() {
        // not yet implemented
    }

}