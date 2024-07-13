package com.mona15dev.mercadolibretest.main.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.mona15dev.mercadolibretest.main.navigation.Navigation
import com.mona15dev.mercadolibretest.main.theme.MercadoLibreTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercadoLibreTestTheme {

                var loadingSplashScreen by rememberSaveable {
                    mutableStateOf(true)
                }

                Navigation(
                    isLoading = { loadingSplashScreen = it },
                    loadingSplashScreen = loadingSplashScreen
                )
            }
        }
    }
}