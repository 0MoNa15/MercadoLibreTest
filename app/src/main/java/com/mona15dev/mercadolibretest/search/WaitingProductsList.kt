package com.mona15dev.mercadolibretest.search

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import com.mona15dev.mercadolibretest.R

const val ITEMS_SHOW_EMPTY = 10

@Composable
fun WaitingProductsList() {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.no_padding)),
        verticalArrangement = Arrangement.Center
    ) {
        items(ITEMS_SHOW_EMPTY) {
            WaintingProductRow()
        }
    }
}

@Composable
fun WaintingProductRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_inside_items_list)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .height(dimensionResource(id = R.dimen.progress_bar_height))
                .weight(1f)
        )
    }
}