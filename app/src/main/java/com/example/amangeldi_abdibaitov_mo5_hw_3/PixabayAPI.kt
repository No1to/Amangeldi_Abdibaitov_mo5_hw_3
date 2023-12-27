package com.example.amangeldi_abdibaitov_mo5_hw_3

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("api/")
    fun getImages(
        @Query("q") keyWord: String,
        @Query("key") key: String = "41487258-86de6d232f9a0d81536343042",
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 3,
    ): Call<PixabayModel>
}