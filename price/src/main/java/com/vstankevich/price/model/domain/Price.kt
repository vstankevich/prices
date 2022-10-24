package com.vstankevich.price.model.domain

data class Price(val marketName: String, val value: String, val direction: PriceDirection = PriceDirection.UNKNOWN)
enum class PriceDirection {
    UP, DOWN, SAME, UNKNOWN
}