package com.jydev.jobplanetandroid.ui.searchresult.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.models.entity.search.ThemeEntity
import com.jydev.jobplanetandroid.ui.searchresult.viewholder.ThemePagerViewHolder


class ThemePagerAdapter(private val glide: RequestManager) :
    RecyclerView.Adapter<ThemePagerViewHolder>() {
    private var themeEntityList : List<ThemeEntity> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemePagerViewHolder {
        return ThemePagerViewHolder.create(glide, parent)
    }

    override fun onBindViewHolder(holder: ThemePagerViewHolder, position: Int) {
        holder.bind(themeEntityList[position])
    }

    override fun getItemCount(): Int =
        themeEntityList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items : List<ThemeEntity>){
        themeEntityList = items
        notifyDataSetChanged()
    }

}
