package org.bytesteam.mobile.scaffold.networking

open class GenericException(val code: String = "") : Throwable()

class AuthTokenExpiredException() : GenericException()