package com.vdevteam.ai_brush_android.remote

import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AIBrushRetrofitService {
    private const val BASE_URL: String = "https://api.replicate.com"
    private var mAPI: IAIBrushRetrofitAPI? = null

    fun getAPI(): IAIBrushRetrofitAPI = mAPI ?: synchronized(this) {
        mAPI ?: createInstance().also {
            mAPI = it
        }
    }

    private fun createInstance(): IAIBrushRetrofitAPI {
        logTraceIn("createInstance")

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(AIBrushAuthInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        logTraceOut("createInstance")
        return retrofit.create(IAIBrushRetrofitAPI::class.java)
    }
}
