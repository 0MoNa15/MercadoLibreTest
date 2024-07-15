package com.mona15dev.domain.product.exceptions

sealed class DataException(message: String?) : Exception(message) {
    class NetworkException(message: String?) : DataException(message)
}