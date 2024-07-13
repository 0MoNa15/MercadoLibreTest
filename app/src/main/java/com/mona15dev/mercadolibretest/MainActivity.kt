package com.mona15dev.mercadolibretest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.mercadolibretest.list.ProductListViewModel
import com.mona15dev.mercadolibretest.ui.theme.MercadoLibreTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercadoLibreTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {

    viewModel.onSearchViewClicked("Motorola")
    val snackbarMessage by viewModel.messageLiveData.observeAsState()
    val listProducts by viewModel.productsByNameListLiveData.observeAsState()

    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        snackbarMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        listProducts?.let {
            Text(
                text = "Products: $it",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MercadoLibreTestTheme {
        Greeting("Android")
    }
}