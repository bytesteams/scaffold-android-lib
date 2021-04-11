package org.bytesteam.mobile.scaffold.base

import androidx.annotation.CallSuper
import org.bytesteam.mobile.scaffold.networking.AuthTokenExpiredException
import org.bytesteam.mobile.scaffold.networking.GenericException

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

    override fun onError(localErrorHandler: ((Throwable) -> Boolean)?): (Throwable) -> Unit {
        return { exception ->
            when (exception) {
                is AuthTokenExpiredException -> view?.showLogon()
                is GenericException -> view?.showError(exception.code)
                else -> view?.showError("Generic error")
            }
        }
    }
}