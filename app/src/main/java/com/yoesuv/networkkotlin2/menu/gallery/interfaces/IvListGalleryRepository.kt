package com.yoesuv.networkkotlin2.menu.gallery.interfaces

import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel

/**
 *  Created by yusuf on 1/14/18.
 */
interface IvListGalleryRepository {
    fun onGetListGallerySuccess(galleryModel: GalleryModel)
    fun onGetListGalleryError()
}