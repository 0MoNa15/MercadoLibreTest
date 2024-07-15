package com.mona15dev.mercadolibretest.list.view

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
import com.mona15dev.mercadolibretest.list.view.state.EmptyListView
import com.mona15dev.mercadolibretest.list.view.state.WaitingProductsList
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel

@Composable
fun ProductListScreen(
    nameProduct: String?,
    navigateToDetailProductScreen: (productId: String) -> Unit,
    productListViewModel: ProductListViewModel = hiltViewModel()
) {
    val products by productListViewModel.productsByNameListLiveData.observeAsState(emptyList())
    val isLoading by productListViewModel.isLoading.observeAsState(false)
    val errorMessage by productListViewModel.messageErrorLiveData.observeAsState()

    LaunchedEffect(nameProduct) {
        if (nameProduct != null && products.isEmpty()) {
            productListViewModel.onSearchByName(nameProduct)
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when {
            isLoading -> {
                WaitingProductsList()
            }
            errorMessage != null -> {
                EmptyListView(stringResource(R.string.error_listando_los_productos))
            }
            products.isNotEmpty() -> {
                ProductListContent(
                    nameProduct = nameProduct,
                    navigateToDetailProductScreen = navigateToDetailProductScreen,
                    modifier = Modifier.padding(innerPadding),
                    products = products
                )
            }
            else -> {
                EmptyListView(title = stringResource(R.string.view_list_products))
            }
        }
    }
}