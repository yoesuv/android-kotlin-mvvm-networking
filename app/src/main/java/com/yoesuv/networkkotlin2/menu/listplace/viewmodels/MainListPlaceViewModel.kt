package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *  Updated by yusuf on 10/15/18.
 */
class MainListPlaceViewModel(application: Application): AndroidViewModel(application) {

    private val listPlaceResponse:ListPlaceResponse = ListPlaceResponse()
    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    var listData: MutableLiveData<ListPlaceModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun requestListPlace(){
        liveLoading.postValue(true)
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            { response ->
                                liveLoading.postValue(false)
                                listData.postValue(response) },
                            { throwable ->
                                liveLoading.postValue(false)
                                throwable.printStackTrace() }
                    )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}