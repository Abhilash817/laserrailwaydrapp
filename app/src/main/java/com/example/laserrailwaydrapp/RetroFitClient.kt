package com.example.laserrailwaydrapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080/") // Emulator → server running on localhost
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    // 👇 Public API instance
    val authApi: AuthApi = retrofit.create(AuthApi::class.java)
}
