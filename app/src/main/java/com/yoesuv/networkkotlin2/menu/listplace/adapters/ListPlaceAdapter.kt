package com.yoesuv.networkkotlin2.menu.listplace.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yoesuv.networkkotlin2.menu.listplace.adapters.viewholders.PlaceViewHolder
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel

/**
 *  Updated by yusuf on 11/27/19.
 */
class ListPlaceAdapter : ListAdapter<ListPlaceModel.Place, PlaceViewHolder>(listPlaceCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        return PlaceViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val listPlaceCallback = object : DiffUtil.ItemCallback<ListPlaceModel.Place>() {
            override fun areItemsTheSame(
                oldItem: ListPlaceModel.Place,
                newItem: ListPlaceModel.Place
            ): Boolean {
                return oldItem.nama == newItem.nama
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: ListPlaceModel.Place,
                newItem: ListPlaceModel.Place
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}