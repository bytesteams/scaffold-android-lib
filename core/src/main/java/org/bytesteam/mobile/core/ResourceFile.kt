package org.bytesteam.mobile.core

import java.nio.charset.Charset

class ResourceFile(private val filePath: String) {

    private val loader: ClassLoader
        get() = Thread.currentThread().contextClassLoader ?: error("Class loader not available!")

    /**
     * Tests whether the file exists and can be accessed.
     */
    fun exist(): Boolean {
        return loader.getResource(filePath) != null
    }

    /**
     * Read the file content completely as a [String].
     */
    fun readText(charset: Charset = Charsets.UTF_8): String {
        if (!exist()) {
            error("File $filePath does not exist or it cannot be accessed!")
        }
        return loader
            .getResourceAsStream(filePath)
            .bufferedReader(charset)
            .use { it.readText() }
    }
}