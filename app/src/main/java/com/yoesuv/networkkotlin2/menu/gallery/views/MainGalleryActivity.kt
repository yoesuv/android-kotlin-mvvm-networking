package com.yoesuv.networkkotlin2.menu.gallery.views

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import android.view.MenuItem
import androidx.activity.viewModels
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.adapters.GalleryAdapter
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.MainGalleryViewModel
import com.yoesuv.networkkotlin2.utils.swipeColors
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Updated by yusuf on 04/19/20.
 */
@AndroidEntryPoint
class MainGalleryActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, MainGalleryActivity::class.java)
        }
    }

    private lateinit var binding: ActivityGalleryBinding
    private val viewModel: MainGalleryViewModel by viewModels()

    private lateinit var adapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        viewModel.requestListGallery()

        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery)
        binding.lifecycleOwner = this
        binding.gallery = viewModel
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarGallery.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.gallery_wisata)
        supportActionBar?.elevation = 5f
    }

    private fun setupRecycler() {
        val lManager = GridLayoutManager(this, 3)
        adapter = GalleryAdapter()
        binding.recyclerviewGallery.layoutManager = lManager
        binding.recyclerviewGallery.adapter = adapter
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshGallery.setColorSchemeColors(*swipeColors())
        binding.swipeRefreshGallery.setOnRefreshListener {
            viewModel.requestListGallery()
        }
    }

    private fun observeData() {
        viewModel.liveDataGallery.observe(this) { galleryModel ->
            adapter.submitList(galleryModel.listData)
        }
    }

}