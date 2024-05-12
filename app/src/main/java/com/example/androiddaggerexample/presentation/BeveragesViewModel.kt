package com.example.androiddaggerexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BeveragesViewModel(private val getPopularBeveragesUseCase: GetPopularBeveragesUseCase) :ViewModel() {

        init {
            println("BeveragesViewModel is working...")
            viewModelScope.launch(Dispatchers.IO) {
                println(getPopularBeveragesUseCase.execute().toString())
            }
        }


}