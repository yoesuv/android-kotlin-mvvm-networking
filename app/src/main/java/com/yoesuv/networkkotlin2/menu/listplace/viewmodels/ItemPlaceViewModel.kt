package com.yoesuv.networkkotlin2.menu.listplace.viewmodels

import androidx.databinding.ObservableField
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ItemPlaceViewModel(place:ListPlaceModel.Place) {

    val name:ObservableField<String?> = ObservableField(place.nama)
    val location:ObservableField<String?> = ObservableField(place.lokasi)
    val imageUrl:ObservableField<String?> = ObservableField(place.thumbnail)

}