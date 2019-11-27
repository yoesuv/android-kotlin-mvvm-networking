package com.yoesuv.networkkotlin2.menu.gallery.views

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.adapters.GalleryAdapter
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.MainGalleryViewModel

/**
 *  Updated by yusuf on 10/15/18.
 */
class MainGalleryActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGalleryBinding
    private lateinit var viewModel:MainGalleryViewModel

    private lateinit var adapter:GalleryAdapter
    private var listGallery:MutableList<GalleryModel.Gallery> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        viewModel.requestListGallery()

        observeData()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery)
        viewModel = ViewModelProviders.of(this).get(MainGalleryViewModel::class.java)
        binding.gallery = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarGallery?.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.gallery_wisata)
        supportActionBar?.elevation = 5f
    }

    private fun setupRecycler(){
        val lManager = androidx.recyclerview.widget.GridLayoutManager(this, 3)
        adapter = GalleryAdapter(this, listGallery)
        binding.recyclerviewGallery.layoutManager = lManager
        binding.recyclerviewGallery.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        binding.swipeRefreshGallery.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        )
        binding.swipeRefreshGallery.isRefreshing = true
        binding.swipeRefreshGallery.setOnRefreshListener {
            viewModel.requestListGallery()
        }
    }

    private fun observeData(){
        viewModel.liveLoading.observe(this, Observer { isLoading ->
            binding.swipeRefreshGallery.isRefreshing = isLoading!!
        })
        viewModel.liveDataGallery.observe(this, Observer { galleryModel ->
            adapter.addData(galleryModel?.listData!!)
            binding.recyclerviewGallery.post {
                adapter.notifyDataSetChanged()
            }
        })
    }

}