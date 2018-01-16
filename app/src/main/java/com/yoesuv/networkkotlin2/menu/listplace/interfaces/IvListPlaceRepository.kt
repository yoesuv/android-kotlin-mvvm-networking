package com.yoesuv.networkkotlin2.menu.listplace.interfaces

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel

/**
 *  Created by yusuf on 1/14/18.
 */
interface IvListPlaceRepository {
    fun onGetListPlaceSuccess(listPlaceModel: ListPlaceModel)
    fun onGetListPlaceError()
}