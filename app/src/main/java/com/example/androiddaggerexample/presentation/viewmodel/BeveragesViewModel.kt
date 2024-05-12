package com.example.androiddaggerexample.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeveragesViewModel(private val getPopularBeveragesUseCase: GetPopularBeveragesUseCase) :ViewModel() {

        init {
            Log.d("logs","BeveragesViewModel is working...")
        }

    fun getPopularBeverages() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("logs",getPopularBeveragesUseCase.execute().toString())
        }
    }


}