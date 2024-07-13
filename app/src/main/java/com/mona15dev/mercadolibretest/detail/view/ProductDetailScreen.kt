package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.mercadolibretest.detail.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(
    productId: String?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    /*
    val uiState by productDetailViewModel.uiState.collectAsState()
    productDetailViewModel.getRecipe(productId)

    Surface(Modifier.fillMaxSize()) {
        ProductDetailContent(
            loading = uiState.loading,
            product = uiState.success,
            error = uiState.error
        )
    }*/
}