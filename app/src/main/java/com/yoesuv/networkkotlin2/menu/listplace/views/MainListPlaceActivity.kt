package com.yoesuv.networkkotlin2.menu.listplace.views

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityListBinding
import com.yoesuv.networkkotlin2.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel

/**
 *  Updated by yusuf on 04/19/20.
 */
class MainListPlaceActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, MainListPlaceActivity::class.java)
        }
    }

    private lateinit var binding:ActivityListBinding
    private lateinit var viewModel:MainListPlaceViewModel

    private lateinit var listPlaceAdapter:ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        viewModel.requestListPlace()

        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[MainListPlaceViewModel::class.java]
        binding.listPlace = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarList.toolbarInclude)
        supportActionBar?.elevation = 5f
        supportActionBar?.title = getString(R.string.list_wisata)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecycler(){
        val lManager = LinearLayoutManager(this)
        binding.recyclerviewListPlace.layoutManager = lManager
        listPlaceAdapter = ListPlaceAdapter()
        binding.recyclerviewListPlace.adapter = listPlaceAdapter
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
            listPlaceAdapter.submitList(listPlace.data)
        })
    }

}