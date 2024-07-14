package com.mona15dev.mercadolibretest.main.navigation

enum class ScreenArgument {
    PRODUCT_ID_ARGUMENT,
    PRODUCT_SEARCH_ARGUMENT;

    override fun toString(): String {
        return when (this) {
            PRODUCT_ID_ARGUMENT -> "product_id_argument"
            PRODUCT_SEARCH_ARGUMENT -> "product_search_argument"
        }
    }
}