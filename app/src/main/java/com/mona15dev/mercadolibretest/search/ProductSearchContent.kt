package com.mona15dev.mercadolibretest.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.mona15dev.domain.product.list.model.Product
import com.mona15dev.mercadolibretest.R

@Composable
fun ProductSearchContent(
    navigateToListProductsScreen: (productId: String) -> Unit,
    products: List<Product>?,
    loading: Boolean?
) {
    Column{
        Column(
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
                Modifier
                    .height(dimensionResource(id = R.dimen.size_search))
                    .background(colorResource(id = R.color.yellow_main))
                    .fillMaxWidth()
            )

            val productsFilter = products?.map { it }?.toMutableStateList()
            val search: (value: String) -> Unit = { query ->
                val result = products?.map { it }?.filter { product ->
                    product.title.contains(query, ignoreCase = true)
                    //Temporal, revisar por que puede ser cualquier dato el que el usuario esté buscando y no solo el titulo
                }

                productsFilter?.apply {
                    clear()
                    addAll(result?.map { it } ?: emptyList())
                }
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.yellow_main),
                        //shape = RoundedCornerShape(percent = 50)
                    )
            ) {
                FieldSearch(search)
            }

            if (loading != null && loading == true) {
                WaitingProductsList()
            } else {
                //Temporal manejar error de cuando no se tengan datos aquí
                
            }
        }
    }
}

@Composable
private fun FieldSearch(
    searchQuery: (value: String) -> Unit
) {
    var searchTerm by rememberSaveable { mutableStateOf("") }

    TextField(
        value = searchTerm,
        onValueChange = {
            searchTerm = it
            searchQuery(it)
        },
        label = {
            val text = stringResource(id = R.string.search_product)
            Text(text = text)
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.search_product)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_double))
    )
}