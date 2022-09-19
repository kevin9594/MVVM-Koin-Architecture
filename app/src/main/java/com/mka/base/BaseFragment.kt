package com.mka.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType

/**
 * @author kevin
 * @description Fragment封裝ViewMode、ViewBinding
 * @param actualTypeArguments 依泛型順序獲取
 */
abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {

    val viewModel: VM by viewModel(clazz = ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VM>).kotlin)

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = ((this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VB>)
            .getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
            .invoke(null, layoutInflater, container, false) as VB

        viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                _binding = null
                super.onDestroy(owner)
            }
        })

        return binding.root
    }

}