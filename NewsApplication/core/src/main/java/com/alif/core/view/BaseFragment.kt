package com.alif.core.view

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.alif.core.view.common.ViewContract
import com.alif.core.view.common.ViewModelContract
import com.alif.core.vm.BaseViewModel

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout), ViewContract {
    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }


    protected fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(viewLifecycleOwner) {
            block.invoke(it)
        }
    }

}

abstract class BaseVMFragment<Result : Any, Error, VM : BaseViewModel<Result, Error>>(
    @LayoutRes layout: Int,
    clazz: Class<VM>
) : BaseFragment(layout), ViewModelContract<Result, Error, VM> {

    protected val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        viewModel(this, clazz)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitVMObservers().invoke(viewModel)
    }

}