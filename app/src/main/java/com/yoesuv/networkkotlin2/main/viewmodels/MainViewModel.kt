package com.yoesuv.networkkotlin2.main.viewmodels

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.yoesuv.networkkotlin2.menu.gallery.views.MainGalleryActivity
import com.yoesuv.networkkotlin2.menu.listplace.views.MainListPlaceActivity

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun clickListPlace(view: View) {
        view.context.startActivity(MainListPlaceActivity.getInstance(view.context))
    }

    fun clickGallery(view: View) {
        view.context.startActivity(MainGalleryActivity.getInstance(view.context))
    }
}