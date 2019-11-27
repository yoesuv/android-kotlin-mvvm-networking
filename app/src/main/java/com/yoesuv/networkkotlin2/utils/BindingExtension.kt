package com.yoesuv.networkkotlin2.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(imageUrl: String) {
    Picasso.with(this.context.applicationContext)
            .load(imageUrl)
            .into(this)
}