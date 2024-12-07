package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceRepository
import com.yoesuv.networkkotlin2.networks.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 *  Updated by yusuf on 11/28/19.
 */
class MainListPlaceViewModel(application: Application) : AndroidViewModel(application) {

    private val listPlaceRepository = ListPlaceRepository()

    var listData: MutableLiveData<ListPlaceModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData(false)

    fun requestListPlace() {
        listPlaceRepository.getListPlace().onEach { res ->
            when (res) {
                is Resource.Loading -> {
                    liveLoading.postValue(true)
                }

                is Resource.Success -> {
                    liveLoading.postValue(false)
                    listData.postValue(res.data)
                }

                is Resource.Error -> {
                    liveLoading.postValue(false)
                }
            }
        }.launchIn(viewModelScope)
    }

}