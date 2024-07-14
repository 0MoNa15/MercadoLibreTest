package com.mona15dev.data.product.detail.dto

import com.google.gson.annotations.SerializedName

data class PictureDto(
    val id: String,

    @SerializedName("secure_url")
    val secureUrl: String
)