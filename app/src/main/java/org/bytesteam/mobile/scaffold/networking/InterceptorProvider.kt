package org.bytesteam.mobile.scaffold.networking

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.bytesteam.mobile.scaffold.BuildConfig
import org.bytesteam.mobile.scaffold.networking.interceptor.BaseHeaderInterceptor
import org.bytesteam.mobile.scaffold.networking.interceptor.ErrorInterceptor
import org.bytesteam.mobile.scaffold.networking.interceptor.MockResponseInterceptor

class InterceptorProvider(
    private val headerInterceptor: BaseHeaderInterceptor,
    private val errorInterceptor: ErrorInterceptor,
    private val loggingInterceptor: HttpLoggingInterceptor,
    private val mockResponseInterceptor: MockResponseInterceptor
) {

    private val interceptors = mutableListOf<Interceptor>()

    fun get(): List<Interceptor> {
        if (BuildConfig.DEBUG) {
            interceptors.add(loggingInterceptor)
            interceptors.add(mockResponseInterceptor)
        }
        interceptors.add(headerInterceptor)
        interceptors.add(errorInterceptor)

        return interceptors
    }
}