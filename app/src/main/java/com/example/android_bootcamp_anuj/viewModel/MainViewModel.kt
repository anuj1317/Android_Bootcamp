package com.example.android_bootcamp_anuj.viewModel

import androidx.lifecycle.ViewModel
import com.example.android_bootcamp_anuj.R
import com.example.android_bootcamp_anuj.model.Items

class MainViewModel() : ViewModel() {
    // ArrayList of class ItemsViewModel
    val data = ArrayList<Items>()

    // This loop will create 20 Views containing
    // the image with the count of view
    fun fetch(){
    for (i in 1..200) {
        data.add(Items(R.drawable.ic_launcher_foreground, "Item " + i))
    }}


}