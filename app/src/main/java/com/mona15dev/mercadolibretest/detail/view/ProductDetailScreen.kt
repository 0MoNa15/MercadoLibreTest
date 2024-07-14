package com.mona15dev.mercadolibretest.detail.view

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
import androidx.hilt.navigation.compose.hiltViewModel
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
                Text(
                    text = errorMessage ?: "Unknown Error",
                    color = Color.Red,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            productDetailState != null -> {
                ProductDetailContent(
                    productDetail = productDetailState!!,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            else -> {
                Text(
                    text = "Cargando...",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

/*
@Composable
fun ProductDetailScreen(
    productId: String?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ProductDetailContent(
            productId = productId,
            modifier = Modifier.padding(innerPadding),
            viewModel = productDetailViewModel
        )
    }
}

fun getMockProductDetail(): ProductDetail {
    return ProductDetail.createProductDetail(
        id = "123",
        price = 1500,
        title = "Motorola",
        pictures = listOf(
            "https://http2.mlstatic.com/D_793201-MLU74074058468_012024-O.jpg",
            "https://http2.mlstatic.com/D_739328-MLU74110339343_012024-O.jpg",
            "https://http2.mlstatic.com/D_664947-MLU73982719092_012024-O.jpg",
            "https://http2.mlstatic.com/D_770087-MLU74085532892_012024-O.jpg"
        ),
        condition = "new"
    )
}*/