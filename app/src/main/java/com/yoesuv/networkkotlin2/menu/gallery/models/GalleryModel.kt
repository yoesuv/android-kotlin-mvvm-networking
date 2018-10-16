package com.yoesuv.networkkotlin2.menu.gallery.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by yusuf on 1/14/18.
 */
class GalleryModel(

        @Expose @SerializedName("status_code") val statusCode:Int?,
        @Expose @SerializedName("data") val listData:MutableList<Gallery>?){

    class Gallery(
            @Expose @SerializedName("caption") val caption:String?,
            @Expose @SerializedName("thumbnail") val thumbnail:String?,
            @Expose @SerializedName("image") val image:String?
    )

}