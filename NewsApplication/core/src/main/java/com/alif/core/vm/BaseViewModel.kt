package com.alif.core.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alif.core.common.Mapper
import com.alif.core.common.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class BaseViewModel<Result : Any, Error>(
    protected val exceptionMapper: Mapper<Throwable, Error>
) : ViewModel() {

    protected open val mutableExceptionLiveDate = SingleLiveEvent<Error>()
    open val exceptionLiveDate: LiveData<Error> = mutableExceptionLiveDate

    protected open val mutableResultLiveData = MutableLiveData<Result>()
    open val resultLiveData: LiveData<Result> = mutableResultLiveData

    private val context =
        SupervisorJob() + Dispatchers.Main + CoroutineExceptionHandler { _, exception ->
            handleThrowable(exception)
        }

    protected val viewModelScope = CoroutineScope(context)

    protected fun handleThrowable(exception: Throwable) {
        mutableExceptionLiveDate.postValue(exceptionMapper.map(exception))
    }

    protected fun launchUI(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Main) {
            block()
        }
    }

    protected fun launchIO(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            block()
        }
    }

    protected fun launchDefault(block: suspend () -> Unit): Job {
        return viewModelScope.launch(Dispatchers.Default) {
            block()
        }
    }

    protected suspend fun <T> asyncHandle(
        block: kotlin.Result<T>,
        error: (suspend (Throwable) -> Unit)? = null,
        success: suspend (T) -> Unit
    ) {
        block.onSuccess {
            success.invoke(it)
        }.onFailure {
            error?.invoke(it) ?: handleThrowable(it)
        }
    }

    protected suspend fun <T> asyncHandle(
        block: suspend () -> T,
        error: (suspend (Throwable) -> Unit)? = null,
        success: suspend (T) -> Unit
    ) {
        asyncHandle(runCatching { block.invoke() }, error, success)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}
