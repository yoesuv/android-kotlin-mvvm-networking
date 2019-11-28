package com.yoesuv.networkkotlin2.menu.gallery.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yoesuv.networkkotlin2.menu.gallery.adapters.viewholders.GalleryViewHolder
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel

/**
 *  Updated by yusuf on 11/27/19.
 */
class GalleryAdapter: ListAdapter<GalleryModel.Gallery, GalleryViewHolder>(galleryCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val galleryCallback = object: DiffUtil.ItemCallback<GalleryModel.Gallery> () {
            override fun areItemsTheSame(oldItem: GalleryModel.Gallery, newItem: GalleryModel.Gallery): Boolean {
                return oldItem.image == newItem.image
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: GalleryModel.Gallery, newItem: GalleryModel.Gallery): Boolean {
                return oldItem == newItem
            }
        }
    }

}