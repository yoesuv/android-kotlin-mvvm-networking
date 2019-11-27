package com.yoesuv.networkkotlin2.utils

import android.util.Log
import com.yoesuv.networkkotlin2.BuildConfig
import com.yoesuv.networkkotlin2.data.AppData

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(AppData.TAG_DEBUG, message)
    }
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(AppData.TAG_ERROR, message)
    }
}