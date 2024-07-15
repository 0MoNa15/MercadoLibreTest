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
import androidx.compose.material.icons.automirrored.twotone.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.model.getShortTitle
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.list.view.state.EmptyListView

@Composable
fun ProductSearchListView(
    navigateToListProductsScreen: (querySearchProduct: String) -> Unit,
    products: List<Product>
) {
    if (products.isEmpty()) {
        EmptyListView(title = stringResource(R.string.view_list_products))
    } else {
        LazyColumn(
            contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(products) { _, product ->
                ProductRow(
                    product = product,
                    navigateToListProductsScreen = navigateToListProductsScreen)
            }
        }
    }
}

@Composable
fun ProductRow(
    product: Product,
    navigateToListProductsScreen: (querySearchProduct: String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navigateToListProductsScreen(product.getShortTitle())
            }
            .padding(dimensionResource(id = R.dimen.padding_double)),
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
            imageVector = Icons.AutoMirrored.TwoTone.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.size_icon))
        )
    }
}