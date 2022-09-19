package com.mka

import com.mka.repository.CityRepository
import com.mka.repository.SignRepository
import com.mka.vm.CityViewModel
import com.mka.vm.MainViewModel
import com.mka.vm.SignViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author kevin
 * @description
 */
val appModule = module {
    viewModel { MainViewModel() }
    viewModel { SignViewModel() }
    viewModel { CityViewModel() }

    single { SignRepository() }
    single { CityRepository() }
}