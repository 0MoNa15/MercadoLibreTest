package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductDetailContent(
    productDetail: ProductDetail,
    modifier: Modifier
) {

    Column(modifier = modifier.padding(dimensionResource(id = R.dimen.padding_double))) {

        ConditionView(condition = productDetail.condition)

        Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.padding)))

        Text(
            text = productDetail.title,
            modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.padding_double))
        )

        Box(modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)) {
            PhotoCarousel(productDetail.pictures)
        }

        Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.padding_double)))

        Text(
            text = productDetail.price.toString(),
            color = Color.Black
        )
    }
}

@Composable
fun ConditionView(condition: ProductCondition) {

    Text(
        text = condition.displayName,
        color = Color.Gray
    )
}

@Composable
fun PhotoCarousel(images: List<String>) {

    LazyRow {
        items(images.size) { index ->

            AsyncImage(
                model = images[index],
                contentDescription = null,
                modifier = Modifier
                    .fillParentMaxWidth()
                    .aspectRatio(1.5f),
                contentScale = ContentScale.Crop
            )
        }
    }
}