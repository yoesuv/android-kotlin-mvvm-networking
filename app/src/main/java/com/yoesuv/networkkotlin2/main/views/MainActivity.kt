package com.yoesuv.networkkotlin2.main.views

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityMainBinding
import com.yoesuv.networkkotlin2.main.viewmodels.CustomViewModelProvidersMain
import com.yoesuv.networkkotlin2.main.viewmodels.MainViewModel
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, CustomViewModelProvidersMain(application, WeakReference(this))).get(MainViewModel::class.java)
        binding.main = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarMain?.toolbarInclude)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.elevation = 5f
    }
}
