package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.util.Log
import com.yoesuv.networkkotlin2.bases.BaseViewModel
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceResponse
import com.yoesuv.networkkotlin2.networks.ResponseRepository
import com.yoesuv.networkkotlin2.menu.listplace.interfaces.IvListPlaceRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *  Created by yusuf on 1/13/18.
 */
class MainListPlaceViewModel(private val ivListPlaceRepository: IvListPlaceRepository) : BaseViewModel {

    private val listPlaceResponse:ListPlaceResponse = ResponseRepository.provideListPlaceRepository()

    override fun onCreate() {
        Log.d("result","MainListPlaceViewModel # onCreate")
        requestListPlace()
    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun requestListPlace(){
        listPlaceResponse.getListPlace()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        {t: ListPlaceModel? ->
                            ivListPlaceRepository.onGetListPlaceSuccess(t!!)
                        },{ _: Throwable? ->
                    ivListPlaceRepository.onGetListPlaceError()
                })
    }
}