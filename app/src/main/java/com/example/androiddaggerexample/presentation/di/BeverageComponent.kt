package com.example.androiddaggerexample.presentation.di

import com.example.androiddaggerexample.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetModule::class,
    RepoModule::class,
    UseCaseModule::class,
    BeverageFactoryModule::class
])
interface BeverageComponent {
    fun inject(beverageActivity: MainActivity)
}