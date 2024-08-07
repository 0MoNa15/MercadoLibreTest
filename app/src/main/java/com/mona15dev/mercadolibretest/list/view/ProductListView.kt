package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.domain.product.list.model.secureThumbnail
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductListView(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    products: List<Product>
) {
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

@Composable
fun ProductItem(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    product: Product
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.padding_4dp)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding)),

        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_double))
                .clickable { navigateToDetailProductScreen(product.id) },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = product.secureThumbnail,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.size_image))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding)))
            )

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_double)))

            Column {
                Text(
                    text = product.title,
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = stringResource(R.string.price, product.price),
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }
    }
}