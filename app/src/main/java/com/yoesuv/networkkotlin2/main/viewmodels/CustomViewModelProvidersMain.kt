package com.yoesuv.networkkotlin2.main.viewmodels

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.ref.WeakReference

class CustomViewModelProvidersMain(private val application: Application, private val weakActivity: WeakReference<Activity>): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(application, weakActivity) as T
    }
}