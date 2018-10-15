package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.yoesuv.networkkotlin2.networks.ListPlaceResponse
import com.yoesuv.networkkotlin2.networks.ResponseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *  Created by yusuf on 1/13/18.
 */
class MainListPlaceViewModel(application: Application): AndroidViewModel(application) {

    private val listPlaceResponse:ListPlaceResponse = ResponseRepository.provideListPlaceRepository()
    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    fun requestListPlace(){
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            { response -> },
                            { throwable -> throwable.printStackTrace() }
                    )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}