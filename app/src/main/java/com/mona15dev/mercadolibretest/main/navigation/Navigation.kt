package com.mona15dev.mercadolibretest.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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

        NavHost(navController = navController, startDestination = ScreenRoute.PRODUCT_SEARCH_SCREEN.toString()) {

            composable(ScreenRoute.PRODUCT_SEARCH_SCREEN.toString()) {
                ProductSearchScreen(
                    navigateToListProductsScreen = {
                        navController.navigate("${ScreenRoute.PRODUCT_LIST_SCREEN}/${it}")
                    }
                )
            }

            /*composable(ScreenRoute.PRODUCT_LIST_SCREEN.toString()) {
                ProductListScreen(
                    navigateToDetailProductScreen = {
                        navController.navigate("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/${it}")
                    }
                )
            }*/

            /*composable(
                route = "${ScreenRoute.PRODUCT_LIST_SCREEN.route}/{query}",
                arguments = listOf(navArgument("query") { type = NavType.StringType })
            ) { backStackEntry ->
                val query = backStackEntry.arguments?.getString("query") ?: ""
                ProductListScreen(
                    query = query,
                    navigateToDetailProductScreen = { productId ->
                        navController.navigate("${ScreenRoute.PRODUCT_DETAIL_SCREEN.route}/$productId")
                    }
                )
            }*/

            composable("${ScreenRoute.PRODUCT_LIST_SCREEN}/{${ScreenArgument.PRODUCT_SEARCH_ARGUMENT}}") {
                //Temporal convertir a rememberSaveable
                val productSearch = remember {
                    it.arguments?.getString(ScreenArgument.PRODUCT_SEARCH_ARGUMENT.toString())
                }

                productSearch?.let {
                    ProductListScreen(
                        productSearch = productSearch,
                        navigateToDetailProductScreen = {
                            navController.navigate("${ScreenRoute.PRODUCT_DETAIL_SCREEN}/${it}")
                        }
                    )
                }
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