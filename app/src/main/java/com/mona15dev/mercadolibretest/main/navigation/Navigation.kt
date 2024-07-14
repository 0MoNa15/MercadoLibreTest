package com.mona15dev.mercadolibretest.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mona15dev.mercadolibretest.detail.view.ProductDetailScreen
import com.mona15dev.mercadolibretest.list.view.ProductListScreen
import com.mona15dev.mercadolibretest.main.views.SplashScreen
import com.mona15dev.mercadolibretest.search.ProductSearchScreen

@Composable
fun Navigation(isLoading: (Boolean) -> Unit, loadingSplashScreen: Boolean) {
    if (loadingSplashScreen) {
        SplashScreen(isLoading = isLoading)
    } else {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = ScreenRoute.PRODUCT_SEARCH_SCREEN.toString()) {

            composable(ScreenRoute.PRODUCT_SEARCH_SCREEN.toString()) {
                ProductSearchScreen(
                    navigateToListProductsScreen = {
                        navController.navigate(ScreenRoute.PRODUCT_LIST_SCREEN.toString())
                    }
                )
            }

            composable(ScreenRoute.PRODUCT_LIST_SCREEN.toString()) {
                ProductListScreen(
                    navigateToDetailProductScreen = { productId ->
                        navController.navigate("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/$productId")
                    }
                )
            }

            composable("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/{${ScreenArgument.PRODUCT_ID_ARGUMENT}}") {
                //Temporal convertir a rememberSaveable
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