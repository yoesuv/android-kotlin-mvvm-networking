package com.yoesuv.networkkotlin2.menu.gallery.models

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by yusuf on 1/14/18.
 */
@Keep
class GalleryModel(
    @Expose @SerializedName("status_code") val statusCode: Int? = 0,
    @Expose @SerializedName("data") val listData: MutableList<Gallery>? = mutableListOf()
) {
    @Keep
    class Gallery(
        @Expose @SerializedName("caption") val caption: String?,
        @Expose @SerializedName("thumbnail") val thumbnail: String?,
        @Expose @SerializedName("image") val image: String?
    )

}