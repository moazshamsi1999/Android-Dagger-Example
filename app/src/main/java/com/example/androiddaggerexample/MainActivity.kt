package com.example.androiddaggerexample

import BeveragesViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddaggerexample.data.BeverageService
import com.example.androiddaggerexample.data.BeveragesRepository
import com.example.androiddaggerexample.domain.GetPopularBeveragesUseCase
import com.example.androiddaggerexample.presentation.BeveragesViewModel
import com.example.androiddaggerexample.ui.theme.AndroidDaggerExampleTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://raw.githubusercontent.com/")
            .build()

        val beveragesRepository = BeveragesRepository(retrofit.create(BeverageService::class.java))
        val getPopularBeveragesUseCase= GetPopularBeveragesUseCase(beveragesRepository)
        val beveragesViewModel: BeveragesViewModel by viewModels { BeveragesViewModelFactory(getPopularBeveragesUseCase = getPopularBeveragesUseCase) }
        beveragesViewModel.getPopularBeverages()
            setContent {
            AndroidDaggerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDaggerExampleTheme {
        Greeting("Android")
    }
}