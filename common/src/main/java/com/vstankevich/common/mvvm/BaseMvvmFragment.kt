package com.vstankevich.common.mvvm

import androidx.fragment.app.Fragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI

abstract class BaseMvvmFragment<VM : BaseViewModel> : Fragment(), DIAware {
    override val di: DI by closestDI()
    abstract val viewModel: VM
}