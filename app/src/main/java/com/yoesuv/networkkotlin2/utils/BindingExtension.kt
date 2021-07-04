package com.yoesuv.networkkotlin2.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.Coil
import coil.request.ImageRequest

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(imageUrl: String) {
    val imageLoader = Coil.imageLoader(this.context)
    val request = ImageRequest.Builder(this.context)
            .data(imageUrl)
            .crossfade(true)
            .target(this)
            .build()
    imageLoader.enqueue(request)
}

@BindingAdapter("setIsRefreshing")
fun SwipeRefreshLayout.setIsRefreshing(value: Boolean) {
    this.isRefreshing = value
}