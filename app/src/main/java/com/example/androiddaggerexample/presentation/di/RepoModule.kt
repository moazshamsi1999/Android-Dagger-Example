package com.example.androiddaggerexample.presentation.di

import com.example.androiddaggerexample.data.BeverageService
import com.example.androiddaggerexample.data.BeveragesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {
    @Provides
    @Singleton
    fun provideBeverageRepository(
        beverageService: BeverageService
    ): BeveragesRepository {

        return BeveragesRepository(
            beverageService
        )
    }
}