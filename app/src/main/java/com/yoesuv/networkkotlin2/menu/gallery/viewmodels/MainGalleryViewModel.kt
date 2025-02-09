package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.networks.GalleryRepository
import com.yoesuv.networkkotlin2.networks.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *  Created by yusuf on 4 jan 2024.
 */
@HiltViewModel
class MainGalleryViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

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