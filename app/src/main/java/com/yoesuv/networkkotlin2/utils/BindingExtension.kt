package com.yoesuv.networkkotlin2.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.api.load

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(imageUrl: String) {
    this.load(imageUrl) {
        crossfade(true)
    }
}

@BindingAdapter("setIsRefreshing")
fun SwipeRefreshLayout.setIsRefreshing(value: Boolean) {
    this.isRefreshing = value
}