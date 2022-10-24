package com.vstankevich.price.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vstankevich.common.mvvm.BaseMvvmFragment
import com.vstankevich.common.mvvm.viewModelLazyInstance
import com.vstankevich.price.R
import com.vstankevich.price.databinding.FragmentPricesBinding

class PriceFragment: BaseMvvmFragment<PriceViewModel>() {

    override val viewModel: PriceViewModel by viewModelLazyInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<FragmentPricesBinding>(inflater, R.layout.fragment_prices, container, false)
            .also { binding ->
                binding.viewModel = viewModel
        }.root
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }
}
