package com.yoesuv.networkkotlin2.menu.listplace.adapters

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ItemPlaceBinding
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.ItemPlaceViewModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ListPlaceAdapter(activity:Activity, private var listPlace: MutableList<ListPlaceModel.Place>) : androidx.recyclerview.widget.RecyclerView.Adapter<ListPlaceAdapter.PlaceViewHolder>() {

    var inflater:LayoutInflater = LayoutInflater.from(activity)

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding:ItemPlaceBinding = DataBindingUtil.inflate(inflater, R.layout.item_place, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val fixPosition = holder.adapterPosition
        holder.bindBinding(listPlace[fixPosition])
    }

    fun addData(mutableList: MutableList<ListPlaceModel.Place>?){
        this.listPlace.clear()
        this.listPlace.addAll(mutableList!!)
    }

    class PlaceViewHolder(itemView: ItemPlaceBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView.root) {

        private val placeBinding:ItemPlaceBinding = itemView

        fun bindBinding(model: ListPlaceModel.Place){
            val placeViewModel = ItemPlaceViewModel(model)
            placeBinding.place = placeViewModel
        }

    }

}