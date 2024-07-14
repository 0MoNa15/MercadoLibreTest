package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.mona15dev.mercadolibretest.R
import com.mona15dev.mercadolibretest.list.viewmodel.ProductListViewModel
import com.mona15dev.mercadolibretest.search.WaitingProductsList

@Composable
fun ProductListContent(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    modifier: Modifier,
    viewModel: ProductListViewModel
) {
    val products by viewModel.productsByNameListLiveData.observeAsState(emptyList())
    val loading by viewModel.isLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.onSearchByName("TITULO")
    }

    Column {
        Column(
            modifier = modifier
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
                modifier
                    .height(dimensionResource(id = R.dimen.size_search))
                    .background(colorResource(id = R.color.yellow_main))
                    .fillMaxWidth()
            )

            Box (
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.yellow_main)
                    )
            ) {
                Text(text = "TITULITO aqui si")
            }

            if (loading != null && loading == true) {
                WaitingProductsList()
            } else {
                //Temporal manejar error de cuando no se tengan datos aquí
                ProductListView(
                    products = products,
                    navigateToDetailProductScreen = navigateToDetailProductScreen
                )
            }
        }
    }
}