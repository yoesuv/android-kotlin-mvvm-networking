package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ItemGalleryViewModel(val gallery: GalleryModel.Gallery) {

    var imageUrl: ObservableField<String?> = ObservableField(gallery.thumbnail)

}