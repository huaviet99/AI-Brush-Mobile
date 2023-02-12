package com.vdevteam.ai_brush_android.remote

import com.vdevteam.ai_brush_android.remote.response.PredictionsResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface IAIBrushRetrofitAPI {
    @GET("/v1/predictions")
    fun getPredictions(): Observable<PredictionsResponse>
}
