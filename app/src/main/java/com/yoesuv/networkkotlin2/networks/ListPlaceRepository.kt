package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import kotlinx.coroutines.flow.Flow

interface ListPlaceRepository {

    fun getListPlace(): Flow<Resource<ListPlaceModel>>

}