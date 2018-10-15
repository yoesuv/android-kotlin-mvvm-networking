package com.yoesuv.networkkotlin2.menu.listplace.views

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityListBinding
import com.yoesuv.networkkotlin2.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel

/**
 *  Created by yusuf on 1/13/18.
 */
class MainListPlaceActivity : AppCompatActivity() {

    private lateinit var listPlaceBinding:ActivityListBinding
    private lateinit var listPlaceViewModel:MainListPlaceViewModel

    private lateinit var adapter:ListPlaceAdapter
    private var listPlace:MutableList<ListPlaceModel.Place> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycle()
        setupSwipeRefresh()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        listPlaceBinding = ActivityListBinding.inflate(LayoutInflater.from(this))

    }

    private fun setupToolbar(){
        setSupportActionBar(listPlaceBinding.toolbarList?.toolbarInclude)
        supportActionBar?.elevation = 5f
        supportActionBar?.title = getString(R.string.list_wisata)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecycle(){
        val lManager = LinearLayoutManager(this)
        lManager.orientation = LinearLayoutManager.VERTICAL

        adapter = ListPlaceAdapter(this, listPlace)
        listPlaceBinding.recyclerviewListPlace.layoutManager = lManager
        listPlaceBinding.recyclerviewListPlace.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        listPlaceBinding.swipeRefreshListPlace.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        )
        listPlaceBinding.swipeRefreshListPlace.isRefreshing = true
        listPlaceBinding.swipeRefreshListPlace.setOnRefreshListener {

        }
    }

}