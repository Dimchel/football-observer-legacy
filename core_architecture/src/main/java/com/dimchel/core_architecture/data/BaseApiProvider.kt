package com.dimchel.core_architecture.data

abstract class BaseApiProvider {

    suspend fun <T : Any> getResponse(requestFunc: suspend () -> T): DataResult<T> =
        try {
            val data = requestFunc()
            DataResult.DataSuccess(data)
        } catch (throwable: Throwable) {
            DataResult.DataError
        }
}