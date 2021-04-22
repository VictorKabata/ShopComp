package com.doe.compshop.mappers

import com.doe.compshop.models.CartProduct
import com.doe.compshop.models.Product

fun CartProduct.toProduct(): Product {
    return Product(
        this.id,
        this.name,
        this.price,
        this.description,
        this.imageUrl,
        this.category,
        this.spec,
        this.inStock,
        this.modelNumber
    )
}