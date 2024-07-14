package com.mona15dev.mercadolibretest.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductListView(
    productSearched: String,
    navigateToListProductsScreen: (productSearched: String) -> Unit,
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
                ProductRow(
                    productSearched = productSearched,
                    product = product,
                    navigateToListProductsScreen = navigateToListProductsScreen)
            }
        }
    }
}

@Composable
fun ProductRow(
    productSearched: String,
    product: Product,
    navigateToListProductsScreen: (productSearched: String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navigateToListProductsScreen(productSearched) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_icon))
                .size(dimensionResource(id = R.dimen.size_icon))
        )

        Text(
            text = product.title,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Left
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowUp, 
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.size_icon))
        )
    }
}