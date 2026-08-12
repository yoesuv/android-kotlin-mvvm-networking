package com.yoesuv.networkkotlin2.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import coil3.request.target
import com.yoesuv.networkkotlin2.R

fun AppCompatImageView.loadImage(imageUrl: ObservableField<String?>) {
    val imageLoader = ImageLoader(this.context)
    val request =
        ImageRequest
            .Builder(this.context)
            .data(imageUrl.get())
            .crossfade(true)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_error)
            .target(this)
            .build()
    imageLoader.enqueue(request)
}

fun SwipeRefreshLayout.setIsRefreshing(value: MutableLiveData<Boolean>) {
    this.isRefreshing = value.value ?: false
}
