package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import android.databinding.ObservableField
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.yoesuv.networkkotlin2.databinding.ItemPlaceBinding
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ItemPlaceViewModel(place:ListPlaceModel.Place, placeBinding: ItemPlaceBinding) {

    val name:ObservableField<String> = ObservableField()
    val location:ObservableField<String> = ObservableField()

    init {
        name.set(place.nama)
        location.set(place.lokasi)

        placeBinding.imgListPlace.scaleType = ImageView.ScaleType.CENTER_CROP
        Picasso.with(placeBinding.root.context.applicationContext)
                .load(place.thumbnail)
                .into(placeBinding.imgListPlace)
    }
}