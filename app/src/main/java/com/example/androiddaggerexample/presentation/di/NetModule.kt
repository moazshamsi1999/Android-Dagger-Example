package com.example.androiddaggerexample.presentation.di

import com.example.androiddaggerexample.data.BeverageService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://popularBeveraged.com/")
            .build()
    }

    @Singleton
    @Provides
    fun provideBeverageService(retrofit: Retrofit): BeverageService {
        return retrofit.create(BeverageService::class.java)
    }
}