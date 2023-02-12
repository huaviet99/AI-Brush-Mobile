package com.vdevteam.ai_brush_android.remote.response

import com.google.gson.annotations.SerializedName

data class PredictionsResponse(
    @SerializedName("results")
    val results: ArrayList<PredictionResultResponse>
)
