package com.alif.core.model

interface Repository {

    abstract class AbstractRepository : Repository {

        protected suspend fun <T> asyncExecute(block: suspend () -> T): Result<T> {
            return runCatching { block.invoke() }
        }

    }
}