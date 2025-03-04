package com.yoesuv.networkkotlin2.menu.listplace.views

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityListBinding
import com.yoesuv.networkkotlin2.menu.listplace.adapters.ListPlaceAdapter
import com.yoesuv.networkkotlin2.menu.listplace.viewmodels.MainListPlaceViewModel
import com.yoesuv.networkkotlin2.utils.handleEdgeToEdge
import com.yoesuv.networkkotlin2.utils.hideStatusBar
import com.yoesuv.networkkotlin2.utils.swipeColors
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Updated by yusuf on 04/19/20.
 */
@AndroidEntryPoint
class MainListPlaceActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, MainListPlaceActivity::class.java)
        }
    }

    private lateinit var binding: ActivityListBinding
    private val viewModel: MainListPlaceViewModel by viewModels()

    private lateinit var listPlaceAdapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        binding.root.handleEdgeToEdge()
        hideStatusBar()

        viewModel.requestListPlace()

        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        binding.lifecycleOwner = this
        binding.listPlace = viewModel
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarList.toolbarInclude)
        supportActionBar?.elevation = 5f
        supportActionBar?.title = getString(R.string.list_wisata)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecycler() {
        val lManager = LinearLayoutManager(this)
        binding.recyclerviewListPlace.layoutManager = lManager
        listPlaceAdapter = ListPlaceAdapter()
        binding.recyclerviewListPlace.adapter = listPlaceAdapter
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshListPlace.setColorSchemeColors(*swipeColors())
        binding.swipeRefreshListPlace.setOnRefreshListener {
            viewModel.requestListPlace()
        }
    }

    private fun observeData() {
        viewModel.listData.observe(this) { listPlace ->
            listPlaceAdapter.submitList(listPlace.data)
        }
    }

}