package com.yoesuv.networkkotlin2.menu.gallery.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.networkkotlin2.databinding.ItemGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.ItemGalleryViewModel

class GalleryViewHolder(val binding: ItemGalleryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gallery: GalleryModel.Gallery) {
        binding.gallery = ItemGalleryViewModel(gallery)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): GalleryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemGalleryBinding =
                ItemGalleryBinding.inflate(layoutInflater, parent, false)
            return GalleryViewHolder(binding)
        }
    }
}