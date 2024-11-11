package com.wikicoding.commerce.model

import jakarta.persistence.*

@Entity
@Table(name = "Products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0,
    @Column(name = "product_name")
    var productName: String = ""
)
