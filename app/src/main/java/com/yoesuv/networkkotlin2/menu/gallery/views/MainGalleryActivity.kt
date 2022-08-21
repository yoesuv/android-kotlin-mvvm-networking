package com.yoesuv.networkkotlin2.menu.gallery.views

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.adapters.GalleryAdapter
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.MainGalleryViewModel

/**
 *  Updated by yusuf on 04/19/20.
 */
class MainGalleryActivity : AppCompatActivity() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, MainGalleryActivity::class.java)
        }
    }

    private lateinit var binding:ActivityGalleryBinding
    private lateinit var viewModel:MainGalleryViewModel

    private lateinit var adapter:GalleryAdapter

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
        if(item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[MainGalleryViewModel::class.java]
        binding.gallery = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarGallery.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.gallery_wisata)
        supportActionBar?.elevation = 5f
    }

    private fun setupRecycler(){
        val lManager = GridLayoutManager(this, 3)
        adapter = GalleryAdapter()
        binding.recyclerviewGallery.layoutManager = lManager
        binding.recyclerviewGallery.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        binding.swipeRefreshGallery.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        )
        binding.swipeRefreshGallery.setOnRefreshListener {
            viewModel.requestListGallery()
        }
    }

    private fun observeData(){
        viewModel.liveDataGallery.observe(this, Observer { galleryModel ->
            adapter.submitList(galleryModel.listData)
        })
    }

}