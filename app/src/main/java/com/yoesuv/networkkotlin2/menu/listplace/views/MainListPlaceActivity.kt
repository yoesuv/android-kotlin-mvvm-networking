package com.yoesuv.networkkotlin2.menu.listplace.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityListBinding
import com.yoesuv.networkkotlin2.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.networkkotlin2.menu.listplace.interfaces.IvListPlaceRepository
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel
import com.yoesuv.networkkotlin2.utils.ApplicationHelper

/**
 *  Created by yusuf on 1/13/18.
 */
class MainListPlaceActivity : AppCompatActivity(), IvListPlaceRepository {

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

        listPlaceViewModel.onCreate()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        listPlaceViewModel.onDestroy()
        super.onDestroy()
    }

    private fun setupBinding(){
        listPlaceBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        listPlaceViewModel = MainListPlaceViewModel(this)
        listPlaceBinding.listPlace = listPlaceViewModel
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
            listPlaceViewModel.requestListPlace()
        }
    }

    override fun onGetListPlaceSuccess(listPlaceModel: ListPlaceModel) {
        listPlaceBinding.swipeRefreshListPlace.isRefreshing = false
        adapter.addData(listPlaceModel.data as MutableList<ListPlaceModel.Place>)
        listPlaceBinding.recyclerviewListPlace.post {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onGetListPlaceError() {
        listPlaceBinding.swipeRefreshListPlace.isRefreshing = false
        ApplicationHelper.Helper.displayToast(this, getString(R.string.error_get_list))
    }
}