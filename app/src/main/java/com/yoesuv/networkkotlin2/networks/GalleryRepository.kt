package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

    fun getListGallery(): Flow<Resource<GalleryModel>>

}