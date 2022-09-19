package com.mka.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType

/**
 * @author kevin
 * @description Activity封裝ViewMode、ViewBinding
 * @param actualTypeArguments 依泛型順序獲取
 */
abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    val viewModel: VM by viewModel(clazz = ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>).kotlin)

    val binding: VB by lazy {
        ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VB>)
            .getMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as VB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}

