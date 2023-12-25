package com.yoesuv.networkkotlin2.networks

import com.google.gson.Gson
import com.yoesuv.networkkotlin2.data.AppData
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListPlaceRepository {

    fun getListPlace(scope: CoroutineScope, onSuccess: (ListPlaceModel) -> Unit) {
        scope.launch {
            val response = Fuel.get(AppData.BASE_URL + EndPoint.LIST_PLACE)
            if (response.statusCode == 200) {
                val gson = Gson()
                val data = gson.fromJson(response.body, ListPlaceModel::class.java)
                onSuccess(data)
            }
        }
    }

}