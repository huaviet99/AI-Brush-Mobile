package com.vdevteam.ai_brush_android.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vdevteam.ai_brush_android.application.AIBrushApplication
import com.vdevteam.ai_brush_android.application.dagger.IAIBrushComponent
import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut

abstract class BaseActivity : AppCompatActivity() {
    abstract fun injectActivity(artGenComponent: IAIBrushComponent)

    // region Android Lifecycles
    override fun onCreate(savedInstanceState: Bundle?) {
        logTraceIn("onCreate")

        // Request injecting target activity to component graph
        injectActivity((applicationContext as AIBrushApplication).artGenComponent)
        super.onCreate(savedInstanceState)

        logTraceOut("onCreate")
    }
    // endregion Android Lifecycles
}
