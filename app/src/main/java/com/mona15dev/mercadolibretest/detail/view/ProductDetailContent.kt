package com.mona15dev.mercadolibretest.detail.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mona15dev.domain.product.detail.model.ProductCondition
import com.mona15dev.domain.product.detail.model.ProductDetail

@Composable
fun ProductDetailContent(
    productDetail: ProductDetail,
    modifier: Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        ConditionView(condition = productDetail.condition)
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = productDetail.title,
            modifier = modifier.padding(bottom = 16.dp)
        )

        Box(modifier = modifier.fillMaxWidth().aspectRatio(1.5f)) {
            PhotoCarousel(productDetail.pictures)
            PhotoCountOverlay(currentIndex = 1, totalCount = productDetail.pictures.size)
        }

        Spacer(modifier = modifier.height(16.dp))
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

@Composable
fun PhotoCountOverlay(currentIndex: Int, totalCount: Int) {
    Text(
        text = "${currentIndex + 1}/$totalCount",
        color = Color.White,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Black.copy(alpha = 0.5f))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}