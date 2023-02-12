package com.vdevteam.ai_brush_android.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vdevteam.ai_brush_android.application.dagger.IAIBrushComponent
import com.vdevteam.ai_brush_android.databinding.FragmentHomeBinding
import com.vdevteam.ai_brush_android.ui.base.BaseFragment
import com.vdevteam.ai_brush_android.ui.home.adapter.InspirationData
import com.vdevteam.ai_brush_android.ui.home.adapter.InspirationRecyclerViewAdapter
import com.vdevteam.ai_brush_android.ui.home.adapter.SelectStyleRecyclerViewAdapter
import com.vdevteam.ai_brush_android.ui.home.adapter.StyleSelectionData
import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut
import javax.inject.Inject

class HomeFragment : BaseFragment() {
    @Inject
    lateinit var mHomeViewModel: HomeViewModel

    private lateinit var mViewBinding: FragmentHomeBinding

    // region Base Abstract Implement Methods
    override fun injectFragment(artGenComponent: IAIBrushComponent) {
        artGenComponent.inject(this)
    }
    // endregion Base Abstract Implement Methods

    // region Android Lifecycles
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logTraceIn("onCreateView")

        mViewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        setupViews()

        logTraceOut("onCreateView")
        return mViewBinding.root
    }
    // endregion Android Lifecycles

    // region Private Methods
    private fun setupViews() {
        logTraceIn("setupViews")

        context?.let { nonNullContext ->
            val selectStyleRecyclerViewAdapter = SelectStyleRecyclerViewAdapter(nonNullContext)
            selectStyleRecyclerViewAdapter.setDataList(
                listOf(
                    StyleSelectionData("https://replicate.delivery/mgxm/e1b194af-e903-4efb-8bb2-8016b0863507/out.png"),
                    StyleSelectionData("https://replicate.delivery/pbxt/aooDunhAPcbUBh979fEblu4qqohEtlG0dPJUf1aLuUkMowCQA/out-0.png"),
                    StyleSelectionData("https://replicate.delivery/mgxm/8d6a8069-b91f-4e61-8136-fa7c0775532c/out-0.png"),
                    StyleSelectionData("https://replicate.delivery/mgxm/e708b96e-735a-4dd8-9ca5-17acd46e76ff/out.png"),
                    StyleSelectionData("https://replicate.delivery/mgxm/452a8297-47e3-4d57-8c1a-b8e9f9ce44b4/out.png"),
                    StyleSelectionData("https://replicate.delivery/pbxt/OnSAoAzeBvU1bye5Kw3zTF4meyHZyW57cQ4DDNBBAHt5eTcBB/out-1.png"),
                    StyleSelectionData("https://replicate.delivery/mgxm/0d5e6ce0-dd85-4dd8-a087-a9c59876b456/out-0.png"),
                )
            )

            mViewBinding.selectStyleRecyclerView.apply {
                adapter = selectStyleRecyclerViewAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            val inspirationRecyclerViewAdapter = InspirationRecyclerViewAdapter(nonNullContext)
            inspirationRecyclerViewAdapter.setDataList(
                listOf(
                    InspirationData("https://replicate.delivery/pbxt/2zVI7LtEO0aeKSruhERO0PQCVEsbFivhEyXyR0LDMSg3cYBIA/out-0.png"),
                    InspirationData("https://replicate.delivery/pbxt/DogdQ8movv5LNlAaHGXrRU9eS1hZMs0OZpIthOsyTbeL6wCQA/out-0.png"),
                    InspirationData("https://replicate.delivery/mgxm/17489d86-982f-4a5d-b184-65e93cee9074/tempfile.png"),
                    InspirationData("https://replicate.delivery/mgxm/62624a19-ccfa-4819-a9a9-83d31b6dacf6/tempfile.png"),
                )
            )

            mViewBinding.inspirationRecyclerView.apply {
                adapter = inspirationRecyclerViewAdapter
                layoutManager = GridLayoutManager(context, 2)
            }
        }
        logTraceOut("setupViews")
    }
    // endregion Private Methods
}
