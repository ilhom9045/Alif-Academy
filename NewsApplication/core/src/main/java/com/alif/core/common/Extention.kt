package com.alif.core.common

import androidx.lifecycle.MutableLiveData
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

inline fun <reified T> clazz(): Class<T> = T::class.java

inline fun <reified T> type(): Type = object : TypeToken<T>() {}.type

fun <T> MutableLiveData<T>.toSingleLiveEvent(): SingleLiveEvent<T> {
    return SingleLiveEvent(this)
}

inline fun Any?.ifNull(block: () -> Unit) {
    if (this == null) {
        block.invoke()
    }
}

inline fun <T> T?.ifNotNull(block: T.() -> Unit) {
    if (this != null) {
        block.invoke(this)
    }
}

inline fun <C, R : Collection<C>> R.ifNotEmpty(defaultValue: R.() -> Unit) =
    if (isNotEmpty()) defaultValue() else Unit