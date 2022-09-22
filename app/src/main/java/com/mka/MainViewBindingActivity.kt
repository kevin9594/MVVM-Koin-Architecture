package com.mka

import android.os.Bundle
import com.mka.base.BaseActivity
import com.mka.databinding.ActivityMainBinding
import com.mka.vm.MainViewModel

class MainViewBindingActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvClick.setOnClickListener {
            viewModel.getResult()
        }
    }

    override suspend fun shareFlowCollect() {
        viewModel.result.collect {
            binding.tvCount.text = "$it"
        }
    }

}