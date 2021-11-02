package com.example.android_bootcamp_anuj.Model

import com.google.gson.annotations.SerializedName


data class Model(
    @SerializedName("id")
    val postID: Int,
    @SerializedName("title")
    val postTitle: String,
    @SerializedName("body")
    val postBody: String
)