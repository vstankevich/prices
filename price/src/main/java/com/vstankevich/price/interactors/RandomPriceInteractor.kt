package com.vstankevich.price.interactors

import com.vstankevich.price.model.RandomPrice
import com.vstankevich.price.model.domain.Market
import com.vstankevich.price.model.domain.Price
import com.vstankevich.price.model.domain.PriceDirection
import com.vstankevich.price.model.toDomain
import com.vstankevich.price.repository.PriceRepository
import io.reactivex.rxjava3.core.Flowable

class RandomPriceInteractor(val repository: PriceRepository): PriceInteractor {

    override fun getPrice(market: Market): Flowable<Price> =
        repository.getPrice(market)
           .filterItems()


    override fun resume(): Flowable<Price> =
        repository.resume()
            .filterItems()

    private fun Flowable<RandomPrice>.filterItems(): Flowable<Price> =
        buffer(2, 1)
            .map {
                it.first().toDomain(it.last())
            }
            .filter { it.direction != PriceDirection.SAME }
}
