package com.yoesuv.networkkotlin2.utils

import android.content.Context
import android.util.Log
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.github.kittinunf.fuel.core.FuelError
import com.yoesuv.networkkotlin2.BuildConfig
import com.yoesuv.networkkotlin2.R
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
fun forTest(): Boolean {
    return BuildConfig.FLAVOR.equals("forTest", true)
}

fun debugPrintStackTrace(fuelError: FuelError) {
    if (BuildConfig.DEBUG) {
        Log.e(AppData.TAG_ERROR,"=============== PrintStackTrace ===============")
        fuelError.printStackTrace()
    }
}

@ColorInt
fun Context.swipeColors(): IntArray  {
    return intArrayOf(
        ContextCompat.getColor(this, R.color.colorPrimary),
        ContextCompat.getColor(this, R.color.colorPrimaryDark),
    )
}