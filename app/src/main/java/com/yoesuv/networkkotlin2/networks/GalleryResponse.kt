package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import io.reactivex.Observable

/**
 *  Created by yusuf on 1/14/18.
 */
class GalleryResponse(private val apiService:RestApi) {

    fun getListGallery():Observable<GalleryModel>{
        return apiService.getListGallery()
    }

}