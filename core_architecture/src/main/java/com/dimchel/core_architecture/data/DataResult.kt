package com.dimchel.core_architecture.data

sealed class DataResult<out T> {
    class DataSuccess<out T>(val result: T) : DataResult<T>()
    object DataError : DataResult<Nothing>()
}

fun <T, NEW> DataResult<T>.mapSuccess(function: (T) -> NEW): DataResult<NEW> =
    when (this) {
        is DataResult.DataSuccess -> DataResult.DataSuccess(function.invoke(result))
        is DataResult.DataError -> this
    }