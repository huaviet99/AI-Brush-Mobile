package com.vdevteam.ai_brush_android.ui.main

import android.os.Bundle
import com.vdevteam.ai_brush_android.application.dagger.IAIBrushComponent
import com.vdevteam.ai_brush_android.databinding.ActivityMainBinding
import com.vdevteam.ai_brush_android.ui.base.BaseActivity
import com.vdevteam.ai_brush_android.ui.home.HomeFragment
import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var mMainViewModel: MainViewModel

    private lateinit var mViewBinding: ActivityMainBinding

    // region Base Abstract Implement Methods
    override fun injectActivity(artGenComponent: IAIBrushComponent) {
        logTraceIn("injectActivity")

        artGenComponent.inject(this)

        logTraceOut("injectActivity")
    }
    // endregion Base Abstract Implement Methods

    // region Android Lifecycles
    override fun onCreate(savedInstanceState: Bundle?) {
        logTraceIn("onCreate")
        super.onCreate(savedInstanceState)
        // Assign binding instance and inflate view layout
        mViewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mViewBinding.root)
        setupView()

        logTraceOut("onCreate")
    }
    // endregion Android Lifecycles

    // region Private Methods
    private fun setupView() {
        logTraceIn("setupView")
        // Change to home fragment when first initializing
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(mViewBinding.mainFrameLayoutContainer.id, HomeFragment())
            .addToBackStack(null)
            .commit()

        logTraceOut("setupView")
    }
    // endregion Private Methods
}
