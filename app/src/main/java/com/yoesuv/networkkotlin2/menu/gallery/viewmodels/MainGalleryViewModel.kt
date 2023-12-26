package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.networks.GalleryRepository

/**
 *  Created by yusuf on 1/14/18.
 */
class MainGalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val galleryRepository = GalleryRepository()

    var liveDataGallery: MutableLiveData<GalleryModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun requestListGallery() {
        liveLoading.postValue(true)
        galleryRepository.getListGallery(viewModelScope, { data ->
            liveLoading.postValue(false)
            liveDataGallery.postValue(data)
        }, {
            liveLoading.postValue(false)
        })
    }

}