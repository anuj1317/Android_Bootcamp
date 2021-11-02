package com.example.android_bootcamp_anuj.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_bootcamp_anuj.repository.MainRepository
import com.example.android_bootcamp_anuj.Model.Model
import kotlinx.coroutines.*

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val dataList = MutableLiveData<List<Model>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
  //Getting data from API
    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getAllData()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    dataList.postValue(response.body())
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
    }
    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}