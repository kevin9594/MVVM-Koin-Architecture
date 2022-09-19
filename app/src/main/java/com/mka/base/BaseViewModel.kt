package com.mka.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mka.SampleApp

/**
 * @author kevin
 * @description
 */
abstract class BaseViewModel: AndroidViewModel(SampleApp.appContext as Application) {


}