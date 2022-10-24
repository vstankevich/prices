package com.vstankevich.common.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.instance

inline fun <reified ViewModelT : BaseViewModel> BaseMvvmFragment<ViewModelT>.viewModelLazyInstance() =
    lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return this@viewModelLazyInstance.di.run {
                    val viewModel by instance<ViewModelT>()
                    viewModel
                } as T
            }
        })
            .get(ViewModelT::class.java)
    }