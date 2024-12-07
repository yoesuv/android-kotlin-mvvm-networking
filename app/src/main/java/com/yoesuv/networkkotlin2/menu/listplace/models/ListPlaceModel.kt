package com.yoesuv.networkkotlin2.menu.listplace.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by yusuf on 1/13/18.
 */
@Keep
data class ListPlaceModel(
    @Expose @SerializedName("status_code") val statusCode: Int? = 0,
    @Expose @SerializedName("data") val data: MutableList<Place>? = mutableListOf()
) {
    @Keep
    data class Place(
        @Expose @SerializedName("nama") val nama: String?,
        @Expose @SerializedName("lokasi") val lokasi: String?,
        @Expose @SerializedName("deskripsi") val deskripsi: String?,
        @Expose @SerializedName("thumbnail") val thumbnail: String?,
        @Expose @SerializedName("gambar") val gambar: String?
    )

}