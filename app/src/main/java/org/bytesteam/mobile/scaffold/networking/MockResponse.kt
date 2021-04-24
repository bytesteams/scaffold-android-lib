package org.bytesteam.mobile.scaffold.networking

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.bytesteam.mobile.core.ResourceFile

private const val DEFAULT_RESPONSE_CODE = 200
private val DEFAULT_MEDIA_TYPE: MediaType = "application/json".toMediaType()
private val DEFAULT_PROTOCOL = Protocol.HTTP_2

internal fun MockResponse(
    request: Request,
    responseBody: ResourceFile,
    mediaType: MediaType = DEFAULT_MEDIA_TYPE,
    responseCode: Int = DEFAULT_RESPONSE_CODE,
    protocol: Protocol = DEFAULT_PROTOCOL
): Response {
    return MockResponse(
        request, responseBody.readText(), mediaType, responseCode, protocol
    )
}

internal fun MockResponse(
    request: Request,
    responseBody: String = "",
    mediaType: MediaType = DEFAULT_MEDIA_TYPE,
    responseCode: Int = DEFAULT_RESPONSE_CODE,
    protocol: Protocol = DEFAULT_PROTOCOL
): Response {
    return Response.Builder()
        .addHeader("Content-Type", mediaType.toString())
        .body(responseBody.toResponseBody(mediaType))
        .message(responseBody)
        .protocol(protocol)
        .code(responseCode)
        .request(request)
        .build()
}