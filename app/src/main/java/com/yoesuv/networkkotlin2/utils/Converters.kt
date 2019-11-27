package com.yoesuv.networkkotlin2.utils

import androidx.databinding.BindingAdapter
import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

class Converters {

    companion object {

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: AppCompatImageView, imageUrl: String?){
            Picasso.with(imageView.context.applicationContext)
                    .load(imageUrl)
                    .into(imageView)
        }

    }

}