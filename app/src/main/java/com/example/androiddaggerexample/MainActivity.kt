package com.example.androiddaggerexample

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
import com.example.androiddaggerexample.presentation.di.BeverageComponent
import com.example.androiddaggerexample.presentation.di.DaggerBeverageComponent
import com.example.androiddaggerexample.presentation.viewmodel.BeveragesViewModel
import com.example.androiddaggerexample.presentation.viewmodel.BeveragesViewModelFactory
import com.example.androiddaggerexample.ui.theme.AndroidDaggerExampleTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    private lateinit var beverageComponent: BeverageComponent
    @Inject
    lateinit var factory: BeveragesViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Idealy DaggerBeverageComponent should be created in Application class,so dependency graph is available throughout the app
        //then in any activity you can access the component and inject the dependencies
        //by doing something like this (applicationContext as YourApplication).yourComponent.inject(this)
        // I wouldve done it like this (applicationContext as BeverageApp).beverageComponent.inject(this)
        beverageComponent= DaggerBeverageComponent.builder().build()
        beverageComponent.inject(this)
        val beveragesViewModel: BeveragesViewModel by viewModels { factory }
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