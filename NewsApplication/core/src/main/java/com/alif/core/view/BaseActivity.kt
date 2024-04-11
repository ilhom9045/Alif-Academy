package com.alif.core.view

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.alif.core.view.common.ViewContract
import com.alif.core.view.common.ViewModelContract
import com.alif.core.vm.BaseViewModel

abstract class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout), ViewContract {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initListener()
    }
}

abstract class BaseVMActivity<Result : Any, Error, VM : BaseViewModel<Result, Error>>(
    @LayoutRes layout: Int,
    clazz: Class<VM>
) : BaseActivity(layout), ViewModelContract<Result, Error, VM> {

    protected val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        viewModel(this, clazz)
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitVMObservers().invoke(viewModel)
    }

    protected fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseVMActivity) {
            block.invoke(it)
        }
    }

}