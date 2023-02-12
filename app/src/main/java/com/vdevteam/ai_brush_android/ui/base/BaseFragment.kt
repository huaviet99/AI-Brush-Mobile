package com.vdevteam.ai_brush_android.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.vdevteam.ai_brush_android.application.AIBrushApplication
import com.vdevteam.ai_brush_android.application.dagger.IAIBrushComponent
import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut

abstract class BaseFragment : Fragment() {
    abstract fun injectFragment(artGenComponent: IAIBrushComponent)

    // region Android Lifecycles
    override fun onCreate(savedInstanceState: Bundle?) {
        logTraceIn("onCreate")

        super.onCreate(savedInstanceState)
        // Request injecting target fragment to component graph
        injectFragment((activity?.applicationContext as AIBrushApplication).artGenComponent)

        logTraceOut("onCreate")
    }
    // endregion Android Lifecycles
}
