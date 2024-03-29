package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceRepository

/**
 *  Updated by yusuf on 11/28/19.
 */
class MainListPlaceViewModel(application: Application) : AndroidViewModel(application) {

    private val listPlaceRepository = ListPlaceRepository()

    var listData: MutableLiveData<ListPlaceModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun requestListPlace() {
        liveLoading.postValue(true)
        listPlaceRepository.getListPlace(viewModelScope, { data ->
            liveLoading.postValue(false)
            listData.postValue(data)
        }) {
            liveLoading.postValue(false)
        }
    }

}