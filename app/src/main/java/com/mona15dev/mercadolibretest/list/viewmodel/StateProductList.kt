package com.mona15dev.mercadolibretest.list.viewmodel

enum class StateProductList {
    IS_LOADING,
    ERROR_MESSAGE,
    PRODUCTS_STATE;

    override fun toString(): String {
        return when (this) {
            IS_LOADING -> "isLoading"
            ERROR_MESSAGE -> "errorMessage"
            PRODUCTS_STATE -> "products"
        }
    }
}