package com.yoesuv.networkkotlin2.networks

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.requests.tryCancel
import com.github.kittinunf.fuel.gson.responseObject
import com.yoesuv.networkkotlin2.data.EndPoint
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.utils.IdlingResource
import com.yoesuv.networkkotlin2.utils.debugPrintStackTrace
import com.yoesuv.networkkotlin2.utils.forTest

class ListPlaceRepository {

    private lateinit var requestListPlace: Request

    fun getListPlace(onSuccess:(ListPlaceModel) -> Unit, onError:(FuelError) -> Unit) {
        if (forTest()) IdlingResource.increment()
        requestListPlace = Fuel.get(EndPoint.LIST_PLACE).responseObject { _, _, result ->
            if (forTest()) {
                if (!IdlingResource.idlingresource.isIdleNow) {
                    IdlingResource.decrement()
                }
            }
            result.fold({
                onSuccess(it)
            }, {
                onError(it)
                debugPrintStackTrace(it)
            })
        }
    }

    fun cleared() {
        requestListPlace.tryCancel(true)
    }
}