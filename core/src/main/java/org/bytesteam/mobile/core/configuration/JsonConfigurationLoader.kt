package org.bytesteam.mobile.core.configuration

import android.content.res.AssetManager
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import kotlin.reflect.KClass

class JsonConfigurationLoader(
    val gson: Gson,
    val assetManager: AssetManager
) : ConfigurationLoader {

    override fun <T : Any> loadConfig(fileName: String, type: KClass<T>): T? {
        return try {
            BufferedReader(InputStreamReader(assetManager.open(fileName)))
                .use { reader -> gson.fromJson(reader, type.java) }
        } catch (ex: IOException) {
            null
        }
    }
}