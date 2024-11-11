package com.wikicoding.commerce.controllers

import com.wikicoding.commerce.dto.ProductRequest
import com.wikicoding.commerce.dto.ProductResponse
import com.wikicoding.commerce.model.Product
import com.wikicoding.commerce.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("products")
class ProductsController(private val repository: ProductRepository) {
    @PostMapping
    fun createProduct(@RequestBody productRequest: ProductRequest): ResponseEntity<ProductResponse> {
        if (validateRequest(productRequest)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)

        val product = Product(productName = productRequest.productName)
        repository.save(product)

        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponse(product.id, product.productName))
    }

    @PutMapping("{product-id}")
    fun updateProduct(@PathVariable(name = "product-id") id: Int,
                      @RequestBody productRequest: ProductRequest): ResponseEntity<ProductResponse> {
        if (validateRequest(productRequest)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)

        val product: Optional<Product> = repository.findById(id)

        if (product.isEmpty) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)

        val updated = product.get()
        updated.productName = productRequest.productName
        repository.save(updated)

        return ResponseEntity.status(HttpStatus.OK).body(ProductResponse(updated.id, updated.productName))
    }

    @DeleteMapping("{product-id}")
    fun deleteProduct(@PathVariable(name = "product-id") id: Int): ResponseEntity<ProductResponse> {
        val product: Optional<Product> = repository.findById(id)

        if (product.isEmpty) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)

        repository.delete(product.get())

        val deleted = product.get()

        return ResponseEntity.status(HttpStatus.OK).body(ProductResponse(deleted.id, deleted.productName))
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> {
        return ResponseEntity.ok(repository.findAll())
    }

    private fun validateRequest(productRequest: ProductRequest): Boolean {
        return productRequest.productName.isEmpty()
    }
}