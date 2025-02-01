package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.utils.JsonParser
import kotlinx.coroutines.flow.flow

class GalleryRepositoryMock : GalleryRepository {

    override fun getListGallery() = flow<Resource<GalleryModel>> {
        val result = JsonParser.stringToObject("gallery.json", GalleryModel::class.java)
        emit(Resource.Success(result))
    }
}