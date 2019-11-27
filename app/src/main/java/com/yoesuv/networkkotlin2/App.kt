package com.yoesuv.networkkotlin2

import android.app.Application
import com.yoesuv.networkkotlin2.utils.logDebug

/**
 *  Created by yusuf on 1/13/18.
 */
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        logDebug("App # onCreate")
    }
}