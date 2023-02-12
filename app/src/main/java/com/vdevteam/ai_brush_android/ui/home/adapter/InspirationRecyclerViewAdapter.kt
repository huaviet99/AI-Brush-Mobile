package com.vdevteam.ai_brush_android.ui.home.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vdevteam.ai_brush_android.databinding.ItemHomeInspirationBinding
import com.vdevteam.ai_brush_android.ui.base.BaseRecyclerViewAdapter

data class InspirationData(val url: String)
class InspirationRecyclerViewAdapter(context: Context) : BaseRecyclerViewAdapter<InspirationData>(context) {

    // region Recycler View Override Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = ItemHomeInspirationBinding.inflate(mLayoutInflater, parent, false)
        return InspirationDataViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerViewData = mDataList[position]
        if (holder is InspirationDataViewHolder && recyclerViewData is InspirationData) {
            holder.bindUI(recyclerViewData)
        }
    }
    // endregion Recycler View Override Methods

    // region Interact Methods
    fun setItemClickListener(itemClickListener: ItemClickListener<InspirationData>) {
        if (mItemClickListener == null) {
            mItemClickListener = itemClickListener
        }
    }
    // endregion Interact Methods

    // region Meme Item

    private inner class InspirationDataViewHolder(private val viewBinding: ItemHomeInspirationBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bindUI(inspirationData: InspirationData) {
            Glide.with(viewBinding.imgCommunityFeedArt)
                .load(inspirationData.url)
                .into(viewBinding.imgCommunityFeedArt)
        }
    }
    // endregion Meme Item
}
