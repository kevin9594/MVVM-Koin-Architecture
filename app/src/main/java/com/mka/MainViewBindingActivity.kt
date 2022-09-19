package com.mka

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.mka.base.BaseActivity
import com.mka.databinding.ActivityMainBinding
import com.mka.vm.MainViewModel
import kotlinx.coroutines.launch

class MainViewBindingActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserve()
        binding.tvClick.setOnClickListener {
            viewModel.getResult()
        }
    }

    private fun initObserve() {
        lifecycleScope.launch {
            viewModel.result.collect {
                binding.tvCount.text = "$it"
            }
        }
    }

}