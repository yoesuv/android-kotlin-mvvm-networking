package com.yoesuv.networkkotlin2.main.views

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yoesuv.networkkotlin2.R
import com.yoesuv.networkkotlin2.databinding.ActivityMainBinding
import com.yoesuv.networkkotlin2.main.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding:ActivityMainBinding
    private lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
    }

    private fun setupBinding(){
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = MainViewModel(this)
        mainBinding.main = mainViewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(mainBinding.toolbarMain?.toolbarInclude)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.elevation = 5f
    }
}
