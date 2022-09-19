package com.mka.vm

import androidx.lifecycle.viewModelScope
import com.mka.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author kevin
 * @create 2022/9/16
 * @description
 */
class MainViewModel : BaseViewModel() {

    private val _result = MutableSharedFlow<Int>()
    val result = _result.asSharedFlow()

    var count = 0

    fun getResult() {
        viewModelScope.launch {
            _result.emit(count)
            count++
        }
    }

}