package com.alif.core.common

interface Mapper<T, R> {

    fun map(data: T): R

    interface Unit<T> : Mapper<T, kotlin.Unit>
}