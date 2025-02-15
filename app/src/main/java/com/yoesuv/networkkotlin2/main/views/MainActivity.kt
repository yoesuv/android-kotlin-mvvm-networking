package com.yoesuv.networkkotlin2.main.views

import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityMainBinding
import com.yoesuv.networkkotlin2.main.viewmodels.MainViewModel
import com.yoesuv.networkkotlin2.utils.handleEdgeToEdge
import com.yoesuv.networkkotlin2.utils.hideStatusBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()

        binding.root.handleEdgeToEdge()
        hideStatusBar()
    }

    private fun setupBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.main = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(binding.toolbarMain.toolbarInclude)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.elevation = 5f
    }
}
