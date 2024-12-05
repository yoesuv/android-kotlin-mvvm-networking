package com.yoesuv.networkkotlin2.networks

import com.google.gson.GsonBuilder
import com.yoesuv.networkkotlin2.data.AppData
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.takeFrom
import io.ktor.serialization.gson.GsonConverter
import io.ktor.serialization.gson.gson

val client = HttpClient {
    defaultRequest {
        url {
            takeFrom(AppData.BASE_URL)
        }
    }
    expectSuccess = true
    install(HttpTimeout) {
        val timeout = 30000L
        connectTimeoutMillis = timeout
        requestTimeoutMillis = timeout
        socketTimeoutMillis = timeout
    }
    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                println(message)
            }
        }
    }
    install(ContentNegotiation) {
        register(ContentType.Text.Any, GsonConverter(GsonBuilder().create()))
        gson {
            setPrettyPrinting()
        }
    }
}