package com.yoesuv.networkkotlin2.networks

import fuel.FuelBuilder
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkService {
    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
    val fuel = FuelBuilder().config(httpClient).build()
}