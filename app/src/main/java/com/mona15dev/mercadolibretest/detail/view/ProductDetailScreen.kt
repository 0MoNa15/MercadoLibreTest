package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.mercadolibretest.detail.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetailScreen(
    productId: String?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ProductDetailContent(
            getMockProductDetail(),
            modifier = Modifier.padding(innerPadding),
            viewModel = productDetailViewModel
        )
    }
}

fun getMockProductDetail(): ProductDetail {
    return ProductDetail.createProductDetail(
        price = "$1500",
        title = "Motorola",
        pictures = listOf(
            "https://http2.mlstatic.com/D_793201-MLU74074058468_012024-O.jpg",
            "https://http2.mlstatic.com/D_739328-MLU74110339343_012024-O.jpg",
            "https://http2.mlstatic.com/D_664947-MLU73982719092_012024-O.jpg",
            "https://http2.mlstatic.com/D_770087-MLU74085532892_012024-O.jpg"
        ),
        condition = "new"
    )
}