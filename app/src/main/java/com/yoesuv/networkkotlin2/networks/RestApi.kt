package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.datas.AppData
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 *  Created by yusuf on 1/13/18.
 */
interface RestApi {

    companion object Factory{
        fun create(): RestApi{

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val clientBuilder = OkHttpClient.Builder()
            clientBuilder.addInterceptor(logging)
            val client = clientBuilder.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(AppData.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(RestApi::class.java)
        }
    }

    @GET("3e17a05acc63f4e696ba4cb15d3b9f2f/raw/3e879b1c5cfe652ca25a18019ca4bc219f20177d/daftar_tempat.json")
    fun getListPlace():Observable<ListPlaceModel>

    @GET("9a306b2244e2878201af1669459e127a/raw/7c7ffbc44c8e9d35731b5197c7e7f00c777e416e/daftar_gallery.json")
    fun getListGallery():Observable<GalleryModel>

}