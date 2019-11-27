package com.yoesuv.networkkotlin2.main.viewmodels

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import android.content.Intent
import android.view.View
import com.yoesuv.networkkotlin2.menu.gallery.views.MainGalleryActivity
import com.yoesuv.networkkotlin2.menu.listplace.views.MainListPlaceActivity
import java.lang.ref.WeakReference

/**
 *  Updated by yusuf on 10/15/18.
 */
class MainViewModel(application: Application, private val weakActivity: WeakReference<Activity>): AndroidViewModel(application) {

    fun clickListWisata(view:View){
        val intent = Intent(weakActivity.get(), MainListPlaceActivity::class.java)
        weakActivity.get()?.startActivity(intent)
    }

    fun clickGalleryWisata(view: View){
        val intent = Intent(weakActivity.get(), MainGalleryActivity::class.java)
        weakActivity.get()?.startActivity(intent)
    }
}