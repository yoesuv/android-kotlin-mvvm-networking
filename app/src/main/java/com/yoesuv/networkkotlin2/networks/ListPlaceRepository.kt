package com.yoesuv.networkkotlin2.networks

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.requests.tryCancel
import com.github.kittinunf.fuel.gson.responseObject
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.utils.logError

class ListPlaceRepository {

    private lateinit var requestListPlace: Request

    fun getListPlace(onSuccess:(ListPlaceModel) -> Unit, onError:(FuelError) -> Unit) {
        requestListPlace = Fuel.get(EndPoint.LIST_PLACE).responseObject<ListPlaceModel> { _, _, result ->
            result.fold({
                onSuccess(it)
            }, {
                onError(it)
                logError("ListPlaceRepository # getListPlace error : ${it.message}")
                it.printStackTrace()
            })
        }
    }

    fun cleared() {
        requestListPlace.tryCancel(true)
    }
}