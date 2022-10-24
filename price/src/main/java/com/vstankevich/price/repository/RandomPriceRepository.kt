package com.vstankevich.price.repository

import com.vstankevich.price.model.RandomPrice
import com.vstankevich.price.model.domain.Market
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class RandomPriceRepository: PriceRepository {

    private var lastMarket: Market = Market.UNKNOWN

    override fun getPrice(market: Market): Flowable<RandomPrice> {
        lastMarket = market
        return Flowable.interval(300, TimeUnit.MILLISECONDS)
            .map {
                RandomPrice(market.name, Math.random())
            }.subscribeOn(Schedulers.computation())
    }

    override fun resume(): Flowable<RandomPrice> =
        when (lastMarket) {
            Market.UNKNOWN -> Flowable.empty()
            else -> getPrice(lastMarket)
        }
}