package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.networks.GalleryRepository
import com.yoesuv.networkkotlin2.networks.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 *  Created by yusuf on 1/14/18.
 */
class MainGalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val galleryRepository = GalleryRepository()

    var liveDataGallery: MutableLiveData<GalleryModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun requestListGallery() {
        galleryRepository.getListGallery().onEach { res ->
            when (res) {
                is Resource.Loading -> {
                    liveLoading.postValue(true)
                }

                is Resource.Success -> {
                    liveLoading.postValue(false)
                    liveDataGallery.postValue(res.data)
                }

                is Resource.Error -> {
                    liveLoading.postValue(false)
                }
            }
        }.launchIn(viewModelScope)
    }

}