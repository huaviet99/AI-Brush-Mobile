package com.vdevteam.ai_brush_android.application

import android.app.Application
import com.vdevteam.ai_brush_android.application.dagger.DaggerIAIBrushComponent
import com.vdevteam.ai_brush_android.application.dagger.IAIBrushComponent

class AIBrushApplication : Application() {
    // Reference to the art gen graph that is used across the whole app
    val artGenComponent: IAIBrushComponent = DaggerIAIBrushComponent.create()
}
