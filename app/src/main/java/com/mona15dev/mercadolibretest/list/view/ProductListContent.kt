package com.mona15dev.mercadolibretest.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductListContent(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    products: List<Product>,
    modifier: Modifier,
) {
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
                Text(text = stringResource(R.string.products_list))
            }

            ProductListView(
                products = products,
                navigateToDetailProductScreen = navigateToDetailProductScreen
            )
        }
    }
}

/*@Composable
fun ProductListContent(
    navigateToDetailProductScreen: (productId: String) -> Unit,
    modifier: Modifier,
    viewModel: ProductListViewModel
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        viewModel.onSearchByName("Lista de productos")
    }

    // Scaffold para manejar la estructura de la pantalla
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.products_list), color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                            tint = Color.Black
                        )
                    }
                },
                backgroundColor = colorResource(id = R.color.yellow_main)
            )
        }
    ) { innerPadding ->
        // Contenido de la pantalla
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            // Gradient Background
            Box(
                modifier = Modifier
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
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.size_search))
                        .background(colorResource(id = R.color.yellow_main))
                        .fillMaxWidth()
                )
            }

            if (loading) {
                WaitingProductsList()
            } else {
                if (products.isEmpty()) {
                    Text(
                        text = stringResource(R.string.not_found_list_products),
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_double)))
                } else {
                    ProductListView(
                        products = products,
                        navigateToDetailProductScreen = navigateToDetailProductScreen
                    )
                }
            }
        }
    }
}

*/