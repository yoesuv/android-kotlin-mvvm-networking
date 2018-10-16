package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import io.reactivex.Observable

/**
 *  Created by yusuf on 1/13/18.
 */
class ListPlaceResponse {

    private val apiService = ServiceFactory.create()

    fun getListPlace():Observable<ListPlaceModel>{
        return apiService.getListPlace()
    }

}