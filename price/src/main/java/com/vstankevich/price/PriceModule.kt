package com.vstankevich.price

import com.vstankevich.price.interactors.PriceInteractor
import com.vstankevich.price.interactors.RandomPriceInteractor
import com.vstankevich.price.presentation.PriceViewModel
import com.vstankevich.price.repository.PriceRepository
import com.vstankevich.price.repository.RandomPriceRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val priceModule = DI.Module("Price Module") {
    bind<PriceRepository>() with singleton { RandomPriceRepository() }
    bind<PriceInteractor>() with singleton { RandomPriceInteractor(instance()) }
    bind<PriceViewModel>() with provider { PriceViewModel(instance()) }
}