package com.example.android_bootcamp_anuj

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlin.coroutines.coroutineContext

class ItemModel(private val context: Context) {
    private val FAVORITE_KEY = "isFavorite"
    // Getting shared preferences reference
    private val preferences: SharedPreferences = context.getSharedPreferences("favorite", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun saveFavoriteItems(favoriteItem: ItemDataClass) {
        editor.putBoolean(FAVORITE_KEY, favoriteItem.isFavorite)
        editor.commit()
        Toast.makeText(context, "Item added to Favorite", Toast.LENGTH_SHORT).show()
    }

    fun getFavoriteItems(): MutableLiveData<Boolean> {
        return MutableLiveData(preferences.getBoolean(FAVORITE_KEY, false))
    }

    fun removeFavoriteItems() {
        editor.remove(FAVORITE_KEY)
        editor.commit()
        Toast.makeText(context, "Item removed from Favorite", Toast.LENGTH_SHORT).show()
    }
}