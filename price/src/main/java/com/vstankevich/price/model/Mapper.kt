package com.vstankevich.price.model

import com.vstankevich.price.model.domain.Price
import com.vstankevich.price.model.domain.PriceDirection

fun RandomPrice.toDomain(prevPrice: RandomPrice): Price {
    val direction = if (this.value > prevPrice.value) {
        PriceDirection.UP
    } else if (this.value < prevPrice.value) {
        PriceDirection.DOWN
    } else PriceDirection.SAME

    return Price(marketName, value.toString(), direction)
}