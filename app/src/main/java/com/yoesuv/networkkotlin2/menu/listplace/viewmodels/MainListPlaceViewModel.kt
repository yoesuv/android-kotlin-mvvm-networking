package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceRepository
import com.yoesuv.networkkotlin2.networks.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 *  Updated by yusuf on 4 Jan 2025.
 */
@HiltViewModel
class MainListPlaceViewModel @Inject constructor(
    application: Application,
    private val listPlaceRepository: ListPlaceRepository,
) : AndroidViewModel(application) {

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