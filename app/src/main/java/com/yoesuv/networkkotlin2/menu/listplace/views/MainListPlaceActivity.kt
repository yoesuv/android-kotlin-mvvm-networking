package com.yoesuv.networkkotlin2.menu.listplace.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityListBinding
import com.yoesuv.networkkotlin2.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.networkkotlin2.menu.listplace.models.ListPlaceModel
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel

/**
 *  Updated by yusuf on 10/15/18.
 */
class MainListPlaceActivity : AppCompatActivity() {

    private lateinit var binding:ActivityListBinding
    private lateinit var viewModel:MainListPlaceViewModel

    private lateinit var adapter:ListPlaceAdapter
    private var listPlace:MutableList<ListPlaceModel.Place> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        viewModel.requestListPlace()

        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        viewModel = ViewModelProviders.of(this).get(MainListPlaceViewModel::class.java)
        binding.listPlace = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarList?.toolbarInclude)
        supportActionBar?.elevation = 5f
        supportActionBar?.title = getString(R.string.list_wisata)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecycler(){
        val lManager = LinearLayoutManager(this)
        lManager.orientation = LinearLayoutManager.VERTICAL

        adapter = ListPlaceAdapter(this, listPlace)
        binding.recyclerviewListPlace.layoutManager = lManager
        binding.recyclerviewListPlace.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        binding.swipeRefreshListPlace.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        )
        binding.swipeRefreshListPlace.setOnRefreshListener {
            viewModel.requestListPlace()
        }
    }

    private fun observeData(){
        viewModel.listData.observe(this, Observer { listPlace ->
            adapter.addData(listPlace?.data)
            binding.recyclerviewListPlace.post {
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.liveLoading.observe(this, Observer {isLoading ->
            binding.swipeRefreshListPlace.isRefreshing = isLoading!!
        })
    }

}