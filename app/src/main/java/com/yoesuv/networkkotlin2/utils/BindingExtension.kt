package com.yoesuv.networkkotlin2.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.Coil
import coil.request.ImageRequest
import com.yoesuv.networkkotlin2.R

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(imageUrl: String) {
    val imageLoader = Coil.imageLoader(this.context)
    val request = ImageRequest.Builder(this.context)
        .data(imageUrl)
        .crossfade(true)
        .placeholder(R.drawable.placeholder_image)
        .target(this)
        .build()
    imageLoader.enqueue(request)
}

@BindingAdapter("setIsRefreshing")
fun SwipeRefreshLayout.setIsRefreshing(value: Boolean) {
    this.isRefreshing = value
}