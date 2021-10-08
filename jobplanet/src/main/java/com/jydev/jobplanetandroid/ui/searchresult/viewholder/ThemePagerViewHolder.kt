package com.jydev.jobplanetandroid.ui.searchresult.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.databinding.ItemSearchResultThemeBinding
import com.jydev.jobplanetandroid.models.entity.search.ThemeEntity
import com.jydev.jobplanetandroid.ui.BaseViewHolder

class ThemePagerViewHolder(private val glide : RequestManager,private val view: ItemSearchResultThemeBinding) : BaseViewHolder<ThemeEntity>(view.root) {
    override fun bind(item: ThemeEntity) {
        with(view){
            themeEntity = item
            glide.load(item.coverImageUrl)
                .into(coverImageView)
        }
    }

    companion object {
        fun create(
            glide: RequestManager,
            parent: ViewGroup
        ): ThemePagerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemSearchResultThemeBinding.inflate(layoutInflater, parent, false)
            return ThemePagerViewHolder(glide, binding)
        }
    }

}