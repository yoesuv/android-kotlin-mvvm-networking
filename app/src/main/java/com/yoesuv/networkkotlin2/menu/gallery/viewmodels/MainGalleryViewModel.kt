package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.networks.GalleryResponse
import com.yoesuv.networkkotlin2.networks.ResponseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *  Created by yusuf on 1/14/18.
 */
class MainGalleryViewModel(application: Application): AndroidViewModel(application) {

    private val galleryResponse:GalleryResponse = ResponseRepository.provideListGalleryRepository()
    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    var liveDataGallery: MutableLiveData<GalleryModel> = MutableLiveData()
    var liveLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun requestListGallery(){
        liveLoading.postValue(true)
        compositeDisposable.add(
            galleryResponse.getListGallery()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({ galleryModel ->
                        liveLoading.postValue(false)
                        liveDataGallery.postValue(galleryModel)
                    }, { throwable ->
                        liveLoading.postValue(false)
                        throwable.printStackTrace()
                    })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}