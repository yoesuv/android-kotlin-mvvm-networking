package com.yoesuv.networkkotlin2

import android.app.Application
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.interceptors.LogRequestInterceptor
import com.github.kittinunf.fuel.core.interceptors.LogResponseInterceptor
import com.yoesuv.networkkotlin2.data.AppData
import com.yoesuv.networkkotlin2.utils.logDebug

/**
 *  Created by yusuf on 1/13/18.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        logDebug("App # onCreate")
        setupFuel()
    }

    private fun setupFuel() {
        val fuelManager = FuelManager.instance
        fuelManager.basePath = AppData.BASE_URL
        fuelManager.timeoutInMillisecond = AppData.TIME_OUT
        fuelManager.timeoutReadInMillisecond = AppData.TIME_OUT
        if (BuildConfig.DEBUG) {
            fuelManager.addRequestInterceptor { LogRequestInterceptor(it) }
            fuelManager.addResponseInterceptor { LogResponseInterceptor(it) }
        }
    }
}