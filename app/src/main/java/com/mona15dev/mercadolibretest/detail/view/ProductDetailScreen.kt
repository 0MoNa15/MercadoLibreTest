package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.detail.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(
    productId: String?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    val productDetailState by productDetailViewModel.productDetailLiveData.observeAsState()
    val isLoading by productDetailViewModel.isLoading.observeAsState(false)
    val errorMessage by productDetailViewModel.messageErrorLiveData.observeAsState()

    productId?.let {
        LaunchedEffect(it) {
            productDetailViewModel.consultProductDetail(it)
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when {
            isLoading -> {
                //CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            errorMessage != null -> {
                EmptyDetailView(
                    message = errorMessage ?: stringResource(R.string.error_default_detail_product),
                    image = R.drawable.ic_error,
                    showButtonReload = true
                )
            }
            productDetailState != null -> {
                ProductDetailContent(
                    productDetail = productDetailState!!,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            else -> {
                EmptyDetailView(
                    message = stringResource(R.string.not_found_detail_product),
                    image = R.drawable.ic_empty_detail
                )
            }
        }
    }
}