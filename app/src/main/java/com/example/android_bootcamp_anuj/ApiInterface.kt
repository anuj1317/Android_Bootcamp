package com.example.android_bootcamp_anuj

import com.example.android_bootcamp_anuj.DataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("/posts")
    fun getData( @Query("id") id: Int): Call<List<DataItem>>
//    @GET("/posts/{id}")
//    fun getData( @Path("id") id: Int): Call<List<DataItem>>

}