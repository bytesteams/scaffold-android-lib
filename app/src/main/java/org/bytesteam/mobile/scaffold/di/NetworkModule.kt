package org.bytesteam.mobile.scaffold.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.bytesteam.mobile.scaffold.networking.InterceptorProvider
import org.bytesteam.mobile.scaffold.networking.interceptor.BaseHeaderInterceptor
import org.bytesteam.mobile.scaffold.networking.interceptor.ErrorInterceptor
import org.bytesteam.mobile.scaffold.networking.interceptor.MockResponseInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideBaseUrl(): HttpUrl {
        return "http://www.sample.com".toHttpUrl()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        baseUrl: HttpUrl,
        okHttpClientBuilder: OkHttpClient.Builder
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClientBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(interceptorProvider: InterceptorProvider): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .apply {
                interceptorProvider.get().forEach { addInterceptor(it) }
                connectTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
            }
    }

    @Singleton
    @Provides
    fun provideInterceptorProvider(
        headerInterceptor: BaseHeaderInterceptor,
        errorInterceptor: ErrorInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        mockResponseInterceptor: MockResponseInterceptor
    ): InterceptorProvider {
        return InterceptorProvider(
            headerInterceptor,
            errorInterceptor,
            httpLoggingInterceptor,
            mockResponseInterceptor
        )
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Singleton
    @Provides
    fun provideMockResponseInterceptor(): MockResponseInterceptor {
        return MockResponseInterceptor()
    }

    @Singleton
    @Provides
    fun provideBaseHeaderInterceptor(): BaseHeaderInterceptor {
        return BaseHeaderInterceptor()
    }

    @Singleton
    @Provides
    fun provideErrorInterceptor(context: Context): ErrorInterceptor {
        return ErrorInterceptor(context)
    }
}