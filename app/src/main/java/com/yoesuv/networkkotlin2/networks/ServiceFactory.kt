package com.yoesuv.networkkotlin2.networks

import com.yoesuv.networkkotlin2.datas.AppData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    
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
}