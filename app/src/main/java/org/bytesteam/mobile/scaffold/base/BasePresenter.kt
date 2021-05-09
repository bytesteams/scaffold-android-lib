package org.bytesteam.mobile.scaffold.base

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import org.bytesteam.mobile.scaffold.networking.AuthTokenExpiredException
import org.bytesteam.mobile.scaffold.networking.GenericException

open class BasePresenter<T : MVPContract.View> : MVPContract.Presenter<T> {

    var view: T? = null

    protected val mainScope: CoroutineScope by lazy { MainScope() }

    @CallSuper
    override fun attachView(view: T) {
        this.view = view
    }

    @CallSuper
    override fun detachView() {
        this.view = null
    }

    override fun onError(error: Throwable, localErrorHandler: ((Throwable) -> Boolean)?) {
        when (error) {
            is AuthTokenExpiredException -> view?.showLogon()
            is GenericException -> view?.showError(error.code)
            else -> view?.showError("Generic error")
        }
    }
}