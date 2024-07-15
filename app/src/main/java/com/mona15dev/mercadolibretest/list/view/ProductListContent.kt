package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductListContent(
    nameProduct: String?,
    navigateToDetailProductScreen: (productId: String) -> Unit,
    products: List<Product>,
    modifier: Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        HeaderSection(
            title = nameProduct ?: "Lista de productos"
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding)))

        ProductListView(
            products = products,
            navigateToDetailProductScreen = navigateToDetailProductScreen
        )
    }
}

@Composable
fun HeaderSection(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.yellow_main))
            .padding(dimensionResource(id = R.dimen.padding_double))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = title,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
        }
    }
}