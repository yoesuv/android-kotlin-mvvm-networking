package com.yoesuv.networkkotlin2.menu.gallery.adapters

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ItemGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.ItemGalleryViewModel

/**
 *  Created by yusuf on 1/14/18.
 */
class GalleryAdapter(activity: Activity, private var listGallery:MutableList<GalleryModel.Gallery>) : androidx.recyclerview.widget.RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private val inflater = LayoutInflater.from(activity)

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val fixPos = holder.adapterPosition
        holder.bindBinding(listGallery[fixPos])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val binding:ItemGalleryBinding = DataBindingUtil.inflate(inflater, R.layout.item_gallery, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    fun addData(mutableList: MutableList<GalleryModel.Gallery>){
        this.listGallery.clear()
        this.listGallery.addAll(mutableList)
    }

    class GalleryViewHolder(itemView: ItemGalleryBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView.root) {

        private val itemGalleryBinding:ItemGalleryBinding = itemView

        fun bindBinding(model:GalleryModel.Gallery){
            val itemGalleryViewModel = ItemGalleryViewModel(model)
            itemGalleryBinding.gallery = itemGalleryViewModel
        }

    }

}