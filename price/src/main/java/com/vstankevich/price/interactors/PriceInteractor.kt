package com.vstankevich.price.interactors

import com.vstankevich.price.model.domain.Market
import com.vstankevich.price.model.domain.Price
import io.reactivex.rxjava3.core.Flowable

interface PriceInteractor {
    fun getPrice(market: Market): Flowable<Price>
    fun resume(): Flowable<Price>
}