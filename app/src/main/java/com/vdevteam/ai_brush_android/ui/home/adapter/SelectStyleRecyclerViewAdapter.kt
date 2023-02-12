package com.vdevteam.ai_brush_android.ui.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vdevteam.ai_brush_android.databinding.ItemHomeSelectStyleBinding
import com.vdevteam.ai_brush_android.ui.base.BaseRecyclerViewAdapter

data class StyleSelectionData(val url: String)
class SelectStyleRecyclerViewAdapter(context: Context) : BaseRecyclerViewAdapter<StyleSelectionData>(context) {

    // region Recycler View Override Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ItemHomeSelectStyleBinding.inflate(mLayoutInflater, parent, false)
        return SelectStyleViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerViewData = mDataList[position]
        if (holder is SelectStyleViewHolder && recyclerViewData is StyleSelectionData) {
            holder.bindUI(recyclerViewData)
        }
    }
    // endregion Recycler View Override Methods

    // region Interact Methods
    fun setItemClickListener(itemClickListener: ItemClickListener<StyleSelectionData>) {
        if (mItemClickListener == null) {
            mItemClickListener = itemClickListener
        }
    }
    // endregion Interact Methods

    // region Meme Item

    private inner class SelectStyleViewHolder(private val viewBinding: ItemHomeSelectStyleBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bindUI(styleSelectionData: StyleSelectionData) {
            Glide.with(viewBinding.imgFeaturedStyleArt)
                .load(styleSelectionData.url)
                .apply(RequestOptions().override(520, 520))
                .into(viewBinding.imgFeaturedStyleArt)
        }
    }
    // endregion Meme Item
}
