package com.yoesuv.networkkotlin2.utils

import android.app.Activity
import android.widget.Toast

/**
 *  Created by yusuf on 1/14/18.
 */
class ApplicationHelper {

    companion object Helper{
        fun displayToast(activity: Activity, message: String){
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }
    }

}