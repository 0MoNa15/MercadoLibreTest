package com.mona15dev.mercadolibretest.detail.viewmodel

enum class StateProductDetail {
    IS_LOADING,
    ERROR_MESSAGE,
    PRODUCT_DETAIL_STATE;

    override fun toString(): String {
        return when (this) {
            IS_LOADING -> "isLoading"
            ERROR_MESSAGE -> "errorMessage"
            PRODUCT_DETAIL_STATE -> "productDetail"
        }
    }
}