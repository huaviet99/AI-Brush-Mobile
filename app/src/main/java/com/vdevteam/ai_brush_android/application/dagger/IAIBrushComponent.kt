package com.vdevteam.ai_brush_android.application.dagger

import com.vdevteam.ai_brush_android.ui.home.HomeFragment
import com.vdevteam.ai_brush_android.ui.main.MainActivity
import dagger.Component

@Component
interface IAIBrushComponent {
    // region Inject Request Method
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    // endregion Inject Request Method
}
