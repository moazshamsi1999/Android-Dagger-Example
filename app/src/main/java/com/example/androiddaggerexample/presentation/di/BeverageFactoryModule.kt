package com.example.androiddaggerexample.presentation.di



import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import com.example.androiddaggerexample.presentation.viewmodel.BeveragesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BeverageFactoryModule {
    @Singleton
    @Provides
    fun providesBeverageFactory(getPopularBeveragesUseCase: GetPopularBeveragesUseCase): BeveragesViewModelFactory {
        return BeveragesViewModelFactory(getPopularBeveragesUseCase)
    }
}