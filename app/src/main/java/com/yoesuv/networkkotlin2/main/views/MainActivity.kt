package com.yoesuv.networkkotlin2.main.views

import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityMainBinding
import com.yoesuv.networkkotlin2.menu.gallery.views.MainGalleryActivity
import com.yoesuv.networkkotlin2.menu.listplace.views.MainListPlaceActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.buttonOne.setOnClickListener {
            startActivity(MainListPlaceActivity.getInstance(this))
        }
        binding.buttonTwo.setOnClickListener {
            startActivity(MainGalleryActivity.getInstance(this))
        }
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarMain?.toolbarInclude)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.elevation = 5f
    }
}
