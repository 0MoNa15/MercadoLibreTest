package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel

@Composable
fun ProductListScreen (
    navigateToDetailProductScreen: (productId: String) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ProductListContent(
            modifier = Modifier.padding(innerPadding),
            navigateToDetailProductScreen = navigateToDetailProductScreen,
            viewModel = viewModel
        )
    }
}
