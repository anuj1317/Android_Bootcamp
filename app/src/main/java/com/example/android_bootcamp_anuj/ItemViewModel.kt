package com.example.android_bootcamp_anuj

import android.app.Application
import android.content.Context
import android.service.autofill.Dataset
import android.util.Log
import androidx.lifecycle.*

class ItemViewModel(application: Application): AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val itemRepository: ItemRepository = ItemRepository(context)
    val isItemFavorite: MutableLiveData<Boolean> = itemRepository.getFavoriteItem()
    private val TAG = ItemViewModel::class.java.simpleName

    fun removeFromFavorite(){
        itemRepository.removeFavoriteItem()
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Remove Fav ${itemRepository.getFavoriteItem().value}")
    }

    fun saveInFavorite(favoriteItem: ItemDataClass) {
        itemRepository.saveFavoriteItem(favoriteItem)
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Save Fav ${itemRepository.getFavoriteItem().value}")
    }
}