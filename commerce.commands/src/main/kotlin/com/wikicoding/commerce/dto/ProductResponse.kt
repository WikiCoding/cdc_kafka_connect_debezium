package com.wikicoding.commerce.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductResponse(
    val id: Int,
    @JsonProperty("product_name")
    val productName: String
)
