package com.mona15dev.mercadolibretest.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel

@Composable
fun ProductSearchScreen(
    navigateToListProductsScreen: (productId: String) -> Unit,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    Surface(Modifier.fillMaxSize()) {
        ProductSearchContent(
            navigateToListProductsScreen = navigateToListProductsScreen,
            viewModel = viewModel
        )
    }
}