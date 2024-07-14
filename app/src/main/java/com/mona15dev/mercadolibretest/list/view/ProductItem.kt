package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductItem(product: Product) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.padding_4dp)),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
        Row(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_double)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://http2.mlstatic.com/D_737539-MLM49765463196_042022-I.jpg",
                contentDescription = "Product Image",
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
                    text = product.price.toString(),
                    modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = "Hasta ${product.price} cuotas",
                    //text = stringResource(id = R.string.installments_text, "24" ?: 12),
                    modifier = Modifier.align(Alignment.Start)
                )
                if (product.price > 100000) {
                    Text(
                        text = stringResource(id = R.string.free_send),
                        modifier = Modifier.align(Alignment.Start)
                    )
                }
            }
        }
    }
}