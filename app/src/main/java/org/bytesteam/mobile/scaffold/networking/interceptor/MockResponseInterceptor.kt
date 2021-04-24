package org.bytesteam.mobile.scaffold.networking.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.bytesteam.mobile.core.ResourceFile
import org.bytesteam.mobile.scaffold.networking.MockResponse

class MockResponseInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        fullPathSegmentProcessors()[request.url.encodedPath]?.let {
            return it.invoke(request)
        }

        for (processor in singlePathSegmentProcessors()) {
            if (request.url.encodedPathSegments.last { it.isNotEmpty() } == processor.key) {
                return processor.value.invoke(request)
            }
        }

        throw Exception("Mock data not provide for ${request.url}")
    }

    private fun fullPathSegmentProcessors(): Map<String, (Request) -> Response> {
        return mapOf(
            "http://www.sample.com/sample-path" to { request ->
                MockResponse(request, ResourceFile("mockdata/sample.json"))
            },
            "http://www.sample.com/sample-path2" to { request ->
                MockResponse(request, "sample body")
            }
        )
    }

    private fun singlePathSegmentProcessors(): Map<String, (Request) -> Response> {
        return mapOf(
            "sample-path" to { request ->
                MockResponse(request, ResourceFile("mockdata/sample.json"))
            },
            "sample-path2" to { request ->
                MockResponse(request, "sample body")
            }
        )
    }
}