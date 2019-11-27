package com.yoesuv.networkkotlin2.menu.listplace.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yoesuv.networkkotlin2.databinding.ItemPlaceBinding
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.ItemPlaceViewModel

class PlaceViewHolder(val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(place: ListPlaceModel.Place) {
        binding.place = ItemPlaceViewModel(place)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PlaceViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemPlaceBinding = ItemPlaceBinding.inflate(layoutInflater, parent, false)
            return PlaceViewHolder(binding)
        }
    }
}