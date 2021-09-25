package com.dimchel.core_architecture.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory<T : ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<T>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModelProvider.get() as T
}

inline fun <reified T : ViewModel> ViewModelFactory<T>.getViewModel(owner: ViewModelStoreOwner): T =
    ViewModelProvider(owner, this).get(T::class.java)