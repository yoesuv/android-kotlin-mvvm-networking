package com.yoesuv.networkkotlin2.menu.gallery.viewmodels

import com.squareup.picasso.Picasso
import com.yoesuv.networkkotlin2.databinding.ItemGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ItemGalleryViewModel(val gallery: GalleryModel.Gallery, binding: ItemGalleryBinding) {

    init {
        Picasso.with(binding.root.context.applicationContext)
                .load(gallery.thumbnail)
                .into(binding.imgItemGallery)
    }

}