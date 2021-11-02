package com.example.android_bootcamp_anuj.repository

import com.example.android_bootcamp_anuj.retrofit.RetrofitService


class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllData() = retrofitService.getAllData()

}