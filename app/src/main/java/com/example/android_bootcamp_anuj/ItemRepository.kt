package com.example.android_bootcamp_anuj

import android.content.Context
import androidx.lifecycle.MutableLiveData

open class ItemRepository(context: Context) {

    private val itemModel: ItemModel = ItemModel(context)

    fun getFavoriteItem() = itemModel.getFavoriteItems()

    fun saveFavoriteItem(favItem: ItemDataClass) = itemModel.saveFavoriteItems(favItem)

    fun removeFavoriteItem() = itemModel.removeFavoriteItems()
}