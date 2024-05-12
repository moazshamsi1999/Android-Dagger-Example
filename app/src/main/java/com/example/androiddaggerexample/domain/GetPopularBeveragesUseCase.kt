package com.example.androiddaggerexample.domain

import com.example.androiddaggerexample.data.BeveragesRepository

class GetPopularBeveragesUseCase(private val beveragesRepository: BeveragesRepository) {
    suspend fun execute(): List<String> {
        return beveragesRepository.getBeverages()
    }
}