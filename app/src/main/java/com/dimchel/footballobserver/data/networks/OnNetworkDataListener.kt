package com.dimchel.footballobserver.data.networks


interface OnNetworkDataListener<in T> {

    fun onResult(result: T)
    fun onFailure(error: NetworkError)

}