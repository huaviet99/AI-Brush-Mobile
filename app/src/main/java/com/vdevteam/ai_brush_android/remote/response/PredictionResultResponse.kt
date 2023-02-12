package com.vdevteam.ai_brush_android.remote.response

import com.google.gson.annotations.SerializedName

data class PredictionResultResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("status")
    val status: String
)
