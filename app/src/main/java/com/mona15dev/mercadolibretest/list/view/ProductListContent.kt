package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel

@Composable
fun ProductListContent(
    modifier: Modifier = Modifier,
    navigateToDetailProductScreen: (recipeId: String) -> Unit,
    viewModel: ProductListViewModel
) {

    LaunchedEffect(Unit) {
       //viewModel.onSearchByName(productSearched)
    }

    val products by viewModel.productsByNameListLiveData.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(false)
    val message by viewModel.messageLiveData.observeAsState()

    Column(modifier = modifier) {
        Text(
            text = "Hello !",
            modifier = modifier
        )

        if (isLoading) {
            CircularProgressIndicator()
        }

        products.forEach { product ->
            Text(text = product.title)
        }

        message?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(top = 16.dp))
        }
    }
}