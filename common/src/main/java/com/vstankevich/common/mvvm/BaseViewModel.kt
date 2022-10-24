package com.vstankevich.common.mvvm

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    private val disposables = CompositeDisposable()

    fun Disposable.toComposite(): Disposable {
        disposables.add(this)
        return this
    }

    public fun onStop() {
        disposables.clear()
    }
}
