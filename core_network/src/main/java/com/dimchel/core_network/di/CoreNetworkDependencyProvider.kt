package com.dimchel.core_network.di

import com.dimchel.core_network.providers.ApiServiceProvider

interface CoreNetworkDependencyProvider {

	fun getApiServiceProvider() : ApiServiceProvider

}