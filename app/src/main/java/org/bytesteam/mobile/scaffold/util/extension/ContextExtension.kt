package org.bytesteam.mobile.scaffold.util.extension

import android.content.Context
import android.net.ConnectivityManager

fun Context.isInternetConnected(): Boolean {
    return (getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.isInternetConnected() == true
}