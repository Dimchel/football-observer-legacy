package com.dimchel.core_image_loader.image_loader

import android.widget.ImageView

interface ImageLoaderProvider {

    fun loadImage(imageUrl: String, imageView: ImageView)
}