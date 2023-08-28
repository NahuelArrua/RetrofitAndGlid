package com.example.viewmodel_livedatakotlin


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(ConsumirApi::class.java)
}

