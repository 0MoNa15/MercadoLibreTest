package com.mona15dev.domain.product.detail.model

enum class ProductCondition(val displayName: String) {
    NEW("Nuevo"),
    USED("Usado");

    companion object {
        fun fromString(condition: String): ProductCondition {
            return when (condition.lowercase()) {
                "new" -> NEW
                else -> USED
            }
        }
    }
}