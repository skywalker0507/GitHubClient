package com.skywalker.github.api

import okhttp3.Interceptor
import okhttp3.Response

class CustomHeaderInterceptor(private val header: String):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original=chain.request()
        val requestBuilder=original.newBuilder().addHeader("Accept",header)
        return chain.proceed(requestBuilder.build())
    }
}