package com.mona15dev.mercadolibretest.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mona15dev.mercadolibretest.detail.view.ProductDetailScreen
import com.mona15dev.mercadolibretest.list.view.ProductListScreen
import com.mona15dev.mercadolibretest.main.views.SplashScreen

@Composable
fun Navigation(isLoading: (Boolean) -> Unit, loadingSplashScreen: Boolean) {
    if (loadingSplashScreen) {
        SplashScreen(isLoading = isLoading)
    } else {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = ScreenRoute.PRODUCT_LIST_SCREEN.toString()) {

            composable(ScreenRoute.PRODUCT_SEARCH_SCREEN.toString()) {

            }

            composable(ScreenRoute.PRODUCT_LIST_SCREEN.toString()) {
                ProductListScreen(
                    navigateToDetailProductScreen = {
                        navController.navigate("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/${it}")
                    }
                )
            }

            composable("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/{${ScreenArgument.PRODUCT_ID_ARGUMENT}}") {
                val productId = remember {
                    it.arguments?.getString(ScreenArgument.PRODUCT_ID_ARGUMENT.toString())
                }

                ProductDetailScreen(
                    productId = productId,
                )
            }
        }
    }
}