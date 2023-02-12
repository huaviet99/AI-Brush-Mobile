package com.vdevteam.ai_brush_android.ui.main

import androidx.lifecycle.ViewModel
import com.vdevteam.ai_brush_android.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel()
