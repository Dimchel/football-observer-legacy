package com.dimchel.core_architecture.data

sealed class ProgressData<out T> {
    object Loading : ProgressData<Nothing>()
    class Success<out T>(val result: T) : ProgressData<T>()
    object Error : ProgressData<Nothing>()
}

fun <T> DataResult<T>.mapToProgressData(): ProgressData<T> =
    when (this) {
        is DataResult.DataSuccess -> ProgressData.Success(result)
        is DataResult.DataError -> ProgressData.Error
    }