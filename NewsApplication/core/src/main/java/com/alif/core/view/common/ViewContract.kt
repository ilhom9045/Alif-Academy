package com.alif.core.view.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.alif.core.vm.BaseViewModel

interface ViewContract {

    fun initView()

    fun initListener() {}

}

interface ViewModelContract<Result : Any, Error, VM : BaseViewModel<Result, Error>> {

    fun <T : ViewModel> viewModel(
        viewModelStoreOwner: ViewModelStoreOwner,
        clazz: Class<T>
    ): T {
        return ViewModelProvider(viewModelStoreOwner)[clazz]
    }

    fun onInitVMObservers(): VM.() -> Unit

}