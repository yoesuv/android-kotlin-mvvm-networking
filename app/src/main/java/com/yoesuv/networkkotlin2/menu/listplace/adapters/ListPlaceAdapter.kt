package com.yoesuv.networkkotlin2.menu.listplace.adapters

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ItemPlaceBinding
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.ItemPlaceViewModel

/**
 *  Created by yusuf on 1/14/18.
 */
class ListPlaceAdapter(activity:Activity, private var mutableList: MutableList<ListPlaceModel.Place>) : RecyclerView.Adapter<ListPlaceAdapter.PlaceViewHolder>() {

    var inflater:LayoutInflater = LayoutInflater.from(activity)

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlaceViewHolder {
        val binding:ItemPlaceBinding = DataBindingUtil.inflate(inflater, R.layout.item_place, parent, false)
        return PlaceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder?, position: Int) {
        val fixPosition = holder?.adapterPosition
        holder?.bindBinding(mutableList[fixPosition!!])
    }

    fun addData(mutableList: MutableList<ListPlaceModel.Place>){
        this.mutableList.clear()
        this.mutableList.addAll(mutableList)
    }

    class PlaceViewHolder(itemView: ItemPlaceBinding) : RecyclerView.ViewHolder(itemView.root) {

        private val placeBinding:ItemPlaceBinding = itemView

        fun bindBinding(model: ListPlaceModel.Place){
            val placeViewModel = ItemPlaceViewModel(model, placeBinding)
            placeBinding.place = placeViewModel
        }

    }

}