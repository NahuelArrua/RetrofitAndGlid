package com.example.viewmodel_livedatakotlin

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ConsumirApi {
    @GET("f1672396-be27-493f-b525-a642deafdf62")
    suspend fun getTraer(): Response<Producto>

}