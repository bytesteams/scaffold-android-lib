package org.bytesteam.mobile.scaffold.base

interface MVPContract {

    interface View {
        fun showLogon()
        fun showError(errorCode: String)
        fun hideError()
    }

    interface Presenter<T : View> {
        fun onError()
    }
}