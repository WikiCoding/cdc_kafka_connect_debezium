package com.wikicoding.commerce.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductRequest(
    @JsonProperty("product_name")
    val productName: String
)
