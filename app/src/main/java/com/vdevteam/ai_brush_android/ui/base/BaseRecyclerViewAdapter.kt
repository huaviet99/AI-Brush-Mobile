package com.vdevteam.ai_brush_android.ui.base

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.vdevteam.ai_brush_android.util.logTraceIn
import com.vdevteam.ai_brush_android.util.logTraceOut

abstract class BaseRecyclerViewAdapter<T>(context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    protected val mDataList = mutableListOf<T>()
    protected val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
    protected lateinit var mItemClickListener: ItemClickListener<T>

    // region Recycler View Override Methods
    override fun getItemCount(): Int {
        return mDataList.size
    }
    // endregion Recycler View Override Methods

    // region Interact Methods
    fun setDataList(list: List<T>) {
        logTraceIn("setDataList: $list")

        mDataList.clear()
        mDataList.addAll(list)
        notifyDataSetChanged()

        logTraceOut("setDataList")
    }

    fun clear() {
        logTraceIn("clear")

        mDataList.clear()
        notifyDataSetChanged()

        logTraceOut("clear")
    }

    // endregion Interact Methods

    interface ItemClickListener<T> {
        fun onClick(position: Int, item: T)
    }
}
