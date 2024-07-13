package com.mona15dev.mercadolibretest.main.navigation

enum class ScreenRoute {
    PRODUCT_SEARCH_SCREEN,
    PRODUCT_LIST_SCREEN,
    PRODUCT_DETAIL_SCREEN;

    override fun toString(): String {
        return when (this) {
            PRODUCT_SEARCH_SCREEN -> "product_search_screen"
            PRODUCT_LIST_SCREEN -> "product_list_screen"
            PRODUCT_DETAIL_SCREEN -> "product_detail_screen"
        }
    }
}