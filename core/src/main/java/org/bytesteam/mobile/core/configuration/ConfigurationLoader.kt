package org.bytesteam.mobile.core.configuration

import kotlin.reflect.KClass

interface ConfigurationLoader {
    fun <T : Any> loadConfig(fileName: String, type: KClass<T>): T?
}

inline fun <reified T : Any> ConfigurationLoader.loadConfig(fileName: String): T? {
    return loadConfig(fileName, T::class)
}

inline fun <reified T : Any> ConfigurationLoader.loadConfig(fileName: String, default: T): T {
    return loadConfig(fileName, T::class) ?: default
}

inline fun <reified T : Any> ConfigurationLoader.requireConfig(fileName: String): T {
    return loadConfig(fileName, T::class)
        ?: throw IllegalStateException("$fileName file does not exist!")
}