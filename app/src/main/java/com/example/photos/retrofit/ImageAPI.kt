package com.example.photos.retrofit

import com.example.photos.models.Images
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ImageAPI {

    @GET("photos")
    suspend fun getResult(
        @Query("page") page: String,
        @Query("per_page") per_page: String,
        @Query("client_id") client_id: String
    ): Response<List<Images>>

}