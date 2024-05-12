package com.example.androiddaggerexample.data

import retrofit2.Response
import retrofit2.http.GET

interface BeverageService {
    @GET("v2/top-beverages")
    suspend fun getTopBeverages(
    ): Response<List<String>>
}