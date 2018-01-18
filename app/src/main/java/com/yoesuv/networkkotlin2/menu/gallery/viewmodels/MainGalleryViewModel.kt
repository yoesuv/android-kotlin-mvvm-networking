package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import com.yoesuv.networkkotlin2.bases.BaseViewModel
import com.yoesuv.networkkotlin2.menu.gallery.interfaces.IvListGalleryRepository
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.networks.GalleryResponse
import com.yoesuv.networkkotlin2.networks.ResponseRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *  Created by yusuf on 1/14/18.
 */
class MainGalleryViewModel(private val ivListGalleryRepository: IvListGalleryRepository) : BaseViewModel {

    private val galleryResponse:GalleryResponse = ResponseRepository.provideListGalleryRepository()
    private val compositeDisposable:CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        requestListGallery()
    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    fun requestListGallery(){
        compositeDisposable.add(
            galleryResponse.getListGallery()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        t: GalleryModel? -> ivListGalleryRepository.onGetListGallerySuccess(t!!)
                    }, { _: Throwable? ->  ivListGalleryRepository.onGetListGalleryError() })
        )
    }
}