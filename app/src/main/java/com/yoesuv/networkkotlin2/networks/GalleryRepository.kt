package com.yoesuv.networkkotlin2.networks

import com.google.gson.Gson
import com.yoesuv.networkkotlin2.data.AppData
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class GalleryRepository {

    fun getListGallery(scope: CoroutineScope, onSuccess: (GalleryModel) -> Unit) {
        scope.launch {
            val response = Fuel.get(AppData.BASE_URL + EndPoint.LIST_GALLERY)
            if (response.statusCode == 200) {
                val gson = Gson()
                val data = gson.fromJson(response.body, GalleryModel::class.java)
                onSuccess(data)
            }
        }
    }

}