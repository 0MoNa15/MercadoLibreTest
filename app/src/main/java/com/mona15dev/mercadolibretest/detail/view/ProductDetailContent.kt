package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.list.view.HeaderSection

@Composable
fun ProductDetailContent(
    productDetail: ProductDetail,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            HeaderSection(
                title = productDetail.title
            )
        }

        item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_double))) }

        item { ConditionView(condition = productDetail.condition) }

        item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding))) }

        item {
            Text(
                text = productDetail.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.padding_double))
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp, max = 300.dp)
            ) {
                PhotoCarousel(productDetail.pictures)
            }
        }

        item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_double))) }

        item {
            Text(
                text = stringResource(R.string.price, productDetail.price),
                color = Color.Black
            )
        }

        item { Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_double))) }

    }
}

@Composable
fun ConditionView(condition: ProductCondition) {
    Text(
        text = stringResource(R.string.state, condition.displayName),
        color = Color.Gray,
        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_4dp))
    )
}

@Composable
fun PhotoCarousel(images: List<String>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.padding_double)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_double))
    ) {
        items(images.size) { index ->
            AsyncImage(
                model = images[index],
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1.5f)
                    .fillParentMaxWidth()
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.padding)))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
        }
    }
}