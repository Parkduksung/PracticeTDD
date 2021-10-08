package com.jydev.jobplanetandroid.ui.searchresult.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.databinding.ItemCompanyThemeBinding
import com.jydev.jobplanetandroid.models.entity.search.HorizontalThemeCellTypeEntity
import com.jydev.jobplanetandroid.ui.BaseViewHolder
import com.jydev.jobplanetandroid.ui.searchresult.adapter.ThemePagerAdapter
import com.jydev.jobplanetandroid.ui.searchresult.adapter.ThemePagerItemDecoration

class CompanyThemeViewHolder(private val glide : RequestManager, private val view : ItemCompanyThemeBinding) : BaseViewHolder<HorizontalThemeCellTypeEntity>(view.root) {
    override fun bind(item: HorizontalThemeCellTypeEntity) {
        with(view){
            themePager.adapter = ThemePagerAdapter(glide).apply {
                setItems(item.themes)
            }
            themePager.addItemDecoration(ThemePagerItemDecoration())
        }
    }
    companion object {
        fun create(
            glide : RequestManager,
            parent: ViewGroup
        ): CompanyThemeViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCompanyThemeBinding.inflate(layoutInflater, parent, false)
            return CompanyThemeViewHolder(glide,binding)
        }
    }
}