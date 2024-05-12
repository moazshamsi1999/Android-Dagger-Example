package com.example.androiddaggerexample.presentation.di

import com.example.androiddaggerexample.data.BeveragesRepository
import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun providePopularBeverageUseCase(beveragesRepository: BeveragesRepository): GetPopularBeveragesUseCase {
        return GetPopularBeveragesUseCase(beveragesRepository)
    }
}