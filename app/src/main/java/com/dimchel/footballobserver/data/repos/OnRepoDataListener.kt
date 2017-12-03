package com.dimchel.footballobserver.data.repos

import com.dimchel.footballobserver.data.networks.NetworkError


interface OnRepoDataListener<in T> {

    fun onResult(result: T)
    fun onFailure(error: NetworkError)

}