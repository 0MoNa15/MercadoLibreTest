package com.mona15dev.mercadolibretest.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel

@Composable
fun ProductSearchContent(
    navigateToListProductsScreen: () -> Unit,
    viewModel: ProductListViewModel
) {
    val products by viewModel.productsByNameListLiveData.observeAsState(emptyList())
    val loading by viewModel.isLoading.observeAsState(false)
    val productsFilter = remember { mutableStateListOf<Product>() }
    val search: (value: String) -> Unit = { query ->
        if (!query.isNullOrEmpty() && query.isNotBlank()) {
            viewModel.onSearchByName(query)
        } else {
            productsFilter.clear()
            productsFilter.addAll(products)
        }
    }

    LaunchedEffect(products) {
        productsFilter.clear()
        productsFilter.addAll(products)
    }

    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 1f,
                        endY = 0f
                    )
                )
        ) {

            Spacer(
                Modifier
                    .height(dimensionResource(id = R.dimen.size_search))
                    .background(colorResource(id = R.color.yellow_main))
                    .fillMaxWidth()
            )

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.yellow_main)
                    )
            ) {
                FieldSearch(search)
            }

            if (loading != null && loading == true) {
                WaitingProductsList()
            } else {
                //Temporal manejar error de cuando no se tengan datos aquí
                ProductListView(
                    products = productsFilter.toList(),
                    navigateToListProductsScreen = navigateToListProductsScreen
                )
            }
        }
    }
}


@Composable
private fun FieldSearch(
    searchQuery: (value: String) -> Unit
) {
    var searchTerm by rememberSaveable { mutableStateOf("") }

    TextField(
        value = searchTerm,
        onValueChange = {
            searchTerm = it
            searchQuery(it)
        },
        label = {
            val text = stringResource(id = R.string.search_product)
            Text(text = text)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.search_product)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_double))
    )
}