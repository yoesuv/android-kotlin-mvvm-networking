package com.yoesuv.networkkotlin2.menu.gallery.views

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityGalleryBinding
import com.yoesuv.networkkotlin2.menu.gallery.adapters.GalleryAdapter
import com.yoesuv.networkkotlin2.menu.gallery.interfaces.IvListGalleryRepository
import com.yoesuv.networkkotlin2.menu.gallery.models.GalleryModel
import com.yoesuv.networkkotlin2.menu.gallery.viewmodels.MainGalleryViewModel
import com.yoesuv.networkkotlin2.utils.ApplicationHelper

/**
 *  Created by yusuf on 1/14/18.
 */
class MainGalleryActivity : AppCompatActivity(), IvListGalleryRepository {

    private lateinit var galleryBinding:ActivityGalleryBinding
    private lateinit var galleryViewModel:MainGalleryViewModel

    private lateinit var adapter:GalleryAdapter
    private var listGallery:MutableList<GalleryModel.Gallery> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupRecycler()
        setupSwipeRefresh()

        galleryViewModel.onCreate()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        galleryViewModel.onDestroy()
        super.onDestroy()
    }

    private fun setupBinding(){
        galleryBinding = DataBindingUtil.setContentView(this, R.layout.activity_gallery)
        galleryViewModel = MainGalleryViewModel(this)
        galleryBinding.gallery = galleryViewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(galleryBinding.toolbarGallery?.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.gallery_wisata)
        supportActionBar?.elevation = 5f
    }

    private fun setupRecycler(){
        val lManager = GridLayoutManager(this, 3)
        adapter = GalleryAdapter(this, listGallery)
        galleryBinding.recyclerviewGallery.layoutManager = lManager
        galleryBinding.recyclerviewGallery.adapter = adapter
    }

    private fun setupSwipeRefresh(){
        galleryBinding.swipeRefreshGallery.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
        )
        galleryBinding.swipeRefreshGallery.isRefreshing = true
        galleryBinding.swipeRefreshGallery.setOnRefreshListener {
            galleryViewModel.requestListGallery()
        }
    }

    override fun onGetListGallerySuccess(galleryModel: GalleryModel) {
        galleryBinding.swipeRefreshGallery.isRefreshing = false
        adapter.addData(galleryModel.listData as MutableList<GalleryModel.Gallery>)
        galleryBinding.recyclerviewGallery.post {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onGetListGalleryError() {
        galleryBinding.swipeRefreshGallery.isRefreshing = false
        ApplicationHelper.Helper.displayToast(this, getString(R.string.error_get_data_gallery))
    }

}