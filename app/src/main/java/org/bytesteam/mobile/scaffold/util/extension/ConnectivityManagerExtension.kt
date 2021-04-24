package org.bytesteam.mobile.scaffold.util.extension

import android.net.ConnectivityManager

@Suppress("DEPRECATION")
fun ConnectivityManager.isInternetConnected(): Boolean {
    var isMobileConnected = false
    var isWiFiConnected = false
    allNetworks.forEach { network ->
        getNetworkInfo(network)?.apply {
            if (type == ConnectivityManager.TYPE_MOBILE) {
                isMobileConnected = isMobileConnected or isConnected
            }
            if (type == ConnectivityManager.TYPE_WIFI) {
                isWiFiConnected = isWiFiConnected or isConnected
            }
        }
    }
    return isMobileConnected or isWiFiConnected
}