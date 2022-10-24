package com.vstankevich.price.repository

import com.vstankevich.price.model.RandomPrice
import com.vstankevich.price.model.domain.Market
import io.reactivex.rxjava3.core.Flowable

interface PriceRepository {
    fun getPrice(market: Market): Flowable<RandomPrice>
    fun resume(): Flowable<RandomPrice>
}