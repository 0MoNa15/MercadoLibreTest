package com.mona15dev.domain.product.list.model

const val MAXIMUM_CHARACTERS_TO_DISPLAY_A_TITLE = 15

data class Product(
    var id: String,
    var title: String,
    var price: Double,
    var thumbnail: String,
    var condition: String
)

fun Product.getShortTitle(): String {
    return if (title.length > MAXIMUM_CHARACTERS_TO_DISPLAY_A_TITLE) {
        "${title.take(MAXIMUM_CHARACTERS_TO_DISPLAY_A_TITLE)}..."
    } else {
        title
    }
}

var Product.secureThumbnail: String
    get() = if (thumbnail.startsWith("http://")) {
        "https://" + thumbnail.substring("http://".length)
    } else {
        thumbnail
    }
    set(value) {
        thumbnail = value
    }