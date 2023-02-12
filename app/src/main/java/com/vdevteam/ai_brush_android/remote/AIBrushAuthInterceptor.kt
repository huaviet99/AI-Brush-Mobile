package com.vdevteam.ai_brush_android.remote

import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut
import okhttp3.Interceptor
import okhttp3.Response

class AIBrushAuthInterceptor : Interceptor {
    companion object {
        private const val TOKEN = "5cf304bd283810a0bb5c9f74105320a3e7ee8123"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        logTraceIn("intercept")
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Authorization", "Token $TOKEN")

        logTraceOut("intercept")
        return chain.proceed(requestBuilder.build())
    }
}
