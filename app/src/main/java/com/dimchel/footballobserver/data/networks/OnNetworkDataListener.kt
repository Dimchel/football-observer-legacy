package com.dimchel.footballobserver.data.networks


interface OnNetworkDataListener<in T> {

    fun onResult(t: T)
    fun onFailure(error: NetworkError)

}