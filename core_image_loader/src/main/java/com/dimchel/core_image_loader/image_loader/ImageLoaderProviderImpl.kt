package com.dimchel.core_image_loader.image_loader

import android.content.Context
import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

class ImageLoaderProviderImpl(
    context: Context
) : ImageLoaderProvider {

    private val imageLoader = ImageLoader.Builder(context)
        .componentRegistry { add(SvgDecoder(context)) }
        .build()

    override fun loadImage(imageUrl: String, imageView: ImageView) {
        imageLoader.enqueue(
            ImageRequest.Builder(imageView.context)
                .data(imageUrl)
                .target(imageView)
                .build()
        )
    }
}