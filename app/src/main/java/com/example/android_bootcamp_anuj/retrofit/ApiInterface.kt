package com.example.android_bootcamp_anuj.retrofit

import com.example.android_bootcamp_anuj.model.DataItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/posts")
    fun getData( @Query("id") id: Int): Call<List<DataItem>>
//    @GET("/posts/{id}")
//    fun getData( @Path("id") id: Int): Call<List<DataItem>>
}