package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.util.Log
import com.yoesuv.networkkotlin2.bases.BaseViewModel
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.networks.ListPlaceResponse
import com.yoesuv.networkkotlin2.networks.ResponseRepository
import com.yoesuv.networkkotlin2.menu.listplace.interfaces.IvListPlaceRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *  Created by yusuf on 1/13/18.
 */
class MainListPlaceViewModel(iface: IvListPlaceRepository) : BaseViewModel {

    private val ivListPlaceRepository: IvListPlaceRepository = iface
    private val listPlaceResponse:ListPlaceResponse = ResponseRepository.provideListPlaceRepository()

    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        Log.d("result","MainListPlaceViewModel # onCreate")
        requestListPlace()
    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    fun requestListPlace(){
        compositeDisposable.add(
            listPlaceResponse.getListPlace()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {t: ListPlaceModel? ->
                                ivListPlaceRepository.onGetListPlaceSuccess(t!!)
                            },{ _: Throwable? ->
                        ivListPlaceRepository.onGetListPlaceError()
                    })
        )
    }
}