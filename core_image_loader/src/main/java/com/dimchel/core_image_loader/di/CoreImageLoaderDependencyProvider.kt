package com.dimchel.core_image_loader.di

import com.dimchel.core_image_loader.image_loader.ImageLoaderProvider

interface CoreImageLoaderDependencyProvider {

    fun getImageLoaderProvider(): ImageLoaderProvider

}