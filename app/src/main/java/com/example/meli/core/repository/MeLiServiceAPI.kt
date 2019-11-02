package com.example.meli.core.repository

import com.example.meli.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MeLiServiceAPI {
    fun create(): MeLiService = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MeLiService::class.java)
}