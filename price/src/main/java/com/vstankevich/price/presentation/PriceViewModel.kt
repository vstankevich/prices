package com.vstankevich.price.presentation

import androidx.databinding.ObservableField
import com.vstankevich.common.mvvm.BaseViewModel
import com.vstankevich.price.interactors.PriceInteractor
import com.vstankevich.price.model.domain.Market
import com.vstankevich.price.model.domain.Price
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable

class PriceViewModel(private val priceInteractor: PriceInteractor): BaseViewModel() {

    private var currentMarketDisposable: Disposable? = null
    val price = ObservableField<Price>()

    fun onAppleMarket() {
        currentMarketDisposable?.dispose()
        currentMarketDisposable = priceInteractor.getPrice(Market.APPLE)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                price.set(it)
            }.toComposite()
    }

    fun onTeslaMarket() {
        currentMarketDisposable?.dispose()
        currentMarketDisposable = priceInteractor.getPrice(Market.TESLA)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                price.set(it)
            }.toComposite()
    }

    fun onGoogleMarket() {
        currentMarketDisposable?.dispose()
        currentMarketDisposable = priceInteractor.getPrice(Market.GOOGLE)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                price.set(it)
            }.toComposite()
    }

    fun onStart() {
        currentMarketDisposable?.dispose()
        currentMarketDisposable = priceInteractor.resume()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                price.set(it)
            }.toComposite()
    }
}
