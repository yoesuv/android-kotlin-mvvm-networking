package com.yoesuv.networkkotlin2.main.viewmodels

import android.app.Activity
import android.content.Intent
import android.view.View
import com.yoesuv.networkkotlin2.bases.BaseViewModel
import com.yoesuv.networkkotlin2.menu.gallery.views.MainGalleryActivity
import com.yoesuv.networkkotlin2.menu.listplace.views.MainListPlaceActivity

/**
 *  Created by yusuf on 1/13/18.
 */
class MainViewModel(private val activity: Activity): BaseViewModel {

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun clikListWisata(view:View){
        val intent = Intent(activity, MainListPlaceActivity::class.java)
        activity.startActivity(intent)
    }

    fun clickGalleryWisata(view: View){
        val intent = Intent(activity, MainGalleryActivity::class.java)
        activity.startActivity(intent)
    }
}