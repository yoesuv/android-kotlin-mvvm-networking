package com.yoesuv.networkkotlin2.networks

import com.google.gson.Gson
import com.yoesuv.networkkotlin2.data.AppData
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import fuel.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListPlaceRepository {

    fun getListPlace(
        scope: CoroutineScope,
        onSuccess: (ListPlaceModel) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        scope.launch {
            val request = Request.Builder().url(AppData.BASE_URL + EndPoint.LIST_PLACE)
                .build()
            try {
                val response = NetworkService.fuel.get(request)
                val gson = Gson()
                val data = gson.fromJson(response.body, ListPlaceModel::class.java)
                onSuccess(data)
            } catch (t: Throwable) {
                onError(t)
            }

        }
    }

}