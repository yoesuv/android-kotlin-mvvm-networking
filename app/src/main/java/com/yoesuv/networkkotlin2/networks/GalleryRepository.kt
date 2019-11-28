package com.yoesuv.networkkotlin2.networks

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.requests.tryCancel
import com.github.kittinunf.fuel.gson.responseObject
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.utils.debugPrintStackTrace

class GalleryRepository {

    private lateinit var requestGallery: Request

    fun getListGallery(onSuccess:(GalleryModel) -> Unit, onError:(FuelError) -> Unit) {
        requestGallery = Fuel.get(EndPoint.LIST_GALLERY).responseObject<GalleryModel> { _, _, result ->
            result.fold({
                onSuccess(it)
            }, {
                onError(it)
                debugPrintStackTrace(it)
            })
        }
    }

    fun cleared() {
        requestGallery.tryCancel(true)
    }
}