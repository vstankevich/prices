package com.vstankevich.pricesapp

import android.app.Application
import com.vstankevich.price.priceModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class PriceApplication: Application(), DIAware {

    override val di by lazy {
        DI {
            import(priceModule)
        }
    }
}