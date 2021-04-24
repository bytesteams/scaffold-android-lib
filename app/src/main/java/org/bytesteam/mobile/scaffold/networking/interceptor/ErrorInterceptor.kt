package org.bytesteam.mobile.scaffold.networking.interceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import org.bytesteam.mobile.scaffold.networking.AuthTokenExpiredException
import org.bytesteam.mobile.scaffold.networking.NoNetworkException
import org.bytesteam.mobile.scaffold.util.extension.isInternetConnected
import java.net.HttpURLConnection

class ErrorInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (isConnected()) {
            return handleApiResponse(chain.proceed(request = chain.request()))
        } else {
            throw NoNetworkException()
        }
    }

    private fun isConnected(): Boolean {
        return context.isInternetConnected()
    }

    private fun handleApiResponse(response: Response): Response {
        when (response.code) {
            HttpURLConnection.HTTP_UNAUTHORIZED,
            HttpURLConnection.HTTP_FORBIDDEN -> {
                handleAuthError()
            }
            in HttpURLConnection.HTTP_OK..HttpURLConnection.HTTP_USE_PROXY -> {
                return handleOkResponse(response)
            }
            else -> handleRequestError(response)
        }
        return response
    }

    private fun handleOkResponse(response: Response): Response {
        // intercept the RESTFUL error here
        return response
    }

    private fun handleAuthError() {
        throw AuthTokenExpiredException()
    }

    private fun handleRequestError(response: Response) {
        // not yet implemented
        // You can customized your error handle here
    }
}