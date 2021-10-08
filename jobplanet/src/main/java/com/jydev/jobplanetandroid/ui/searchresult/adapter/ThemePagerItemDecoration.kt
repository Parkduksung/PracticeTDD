package com.jydev.jobplanetandroid.ui.searchresult.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jydev.jobplanetandroid.util.dp

class ThemePagerItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(10.dp,0,10.dp,0)
    }
}