package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import android.databinding.ObservableField
import com.squareup.picasso.Picasso
import com.yoesuv.networkkotlin2.databinding.ItemGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ItemGalleryViewModel(val gallery: GalleryModel.Gallery) {

    var imageUrl: ObservableField<String?> = ObservableField(gallery.thumbnail)

}