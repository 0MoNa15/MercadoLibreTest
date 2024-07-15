package com.mona15dev.mercadolibretest.list.view.state

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mona15dev.mercadolibretest.R

@Composable
fun EmptyListView(
    title: String
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_double))
    ) {
        val maxHeight = maxHeight
        val maxWidth = maxWidth

        val imageSize = if (maxHeight < maxWidth) {
            maxHeight * 0.5f
        } else {
            maxWidth * 0.5f
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty_list),
                contentDescription = null,
                modifier = Modifier.size(imageSize)
            )

            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = dimensionResource(id = R.dimen.padding))
            )
        }
    }
}
