package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.search.EmptyListView

@Composable
fun ProductListView(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    products: List<Product>
) {
    if (products.isEmpty()) {
        EmptyListView()
    } else {
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(products) { _, product ->
                ProductItem(
                    product = product,
                    navigateToDetailProductScreen = navigateToDetailProductScreen)
            }
        }
    }
}