package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.utils.JsonParser
import kotlinx.coroutines.flow.flow

class ListPlaceRepositoryMock : ListPlaceRepository {

    override fun getListPlace() = flow<Resource<ListPlaceModel>> {
        val result = JsonParser.stringToObject("list_place.json", ListPlaceModel::class.java)
        emit(Resource.Success(result))
    }
}