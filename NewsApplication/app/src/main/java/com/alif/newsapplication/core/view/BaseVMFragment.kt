package com.alif.newsapplication.core.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.alif.core.view.BaseVMFragment
import com.alif.core.vm.BaseViewModel

abstract class BaseNewsVMFragment<R : Any, VM : BaseViewModel<R, String>>(
    @LayoutRes layout: Int,
) : BaseVMFragment<R, String, VM>(layout)

abstract class BaseNewsNetworkVMFragment<R : Any, VM : BaseViewModel<R, String>>(
    @LayoutRes layout: Int,
) : BaseVMFragment<R, String, VM>(layout) {

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.exceptionLiveDate.observe {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}