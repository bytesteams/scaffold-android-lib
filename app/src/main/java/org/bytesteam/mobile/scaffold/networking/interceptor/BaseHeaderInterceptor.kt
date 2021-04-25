package org.bytesteam.mobile.scaffold.networking.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class BaseHeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder().apply {
            addHeader("sample", "value")
        }.build()
        return chain.proceed(newRequest)
    }
}