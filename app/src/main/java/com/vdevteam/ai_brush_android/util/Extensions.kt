package com.vdevteam.ai_brush_android.util

import android.util.Log
import com.vdevteam.ai_brush_android.BuildConfig

val Any.TAG: String
    get() {
        val tag = javaClass.simpleName
        return if (tag.length <= 23) tag else tag.substring(0, 23)
    }

// region Debug Logger Methods
fun Any.logTraceIn(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, "TRACE_IN>>> [$TAG] $message")
    }
}

fun Any.logTraceOut(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, "TRACE_OUT>> [$TAG] $message")
    }
}

fun Any.logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, "ERROR>> [$TAG] $message")
    }
}

fun Any.logError(message: String, throwable: Throwable) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, "ERROR>> [$TAG] $message", throwable)
    }
}

fun Any.logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, "DEBUG>>> [$TAG] $message")
    }
}
// endregion Debug Logger Methods
