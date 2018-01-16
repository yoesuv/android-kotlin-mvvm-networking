package com.yoesuv.networkkotlin2.networks

/**
 *  Created by yusuf on 1/13/18.
 */
object ResponseRepository {

    fun provideListPlaceRepository():ListPlaceResponse{
        return ListPlaceResponse(RestApi.Factory.create())
    }

    fun provideListGalleryRepository():GalleryResponse{
        return GalleryResponse(RestApi.Factory.create())
    }

}