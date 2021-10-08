package com.jydev.jobplanetandroid.ui.searchresult.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.models.entity.search.CompanyCellTypeEntity
import com.jydev.jobplanetandroid.models.entity.search.SearchCellTypeEntity
import com.jydev.jobplanetandroid.ui.searchresult.viewholder.CompanyReviewViewHolder
import com.jydev.jobplanetandroid.ui.searchresult.viewholder.CompanyThemeViewHolder
import com.jydev.jobplanetandroid.ui.searchresult.viewholder.CompanyViewHolder

class SearchResultAdapter(
    private val glide: RequestManager,
    private val gotoCompanyDetail: (CompanyCellTypeEntity) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var searchCellTypeList: List<SearchCellTypeEntity> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            TYPE_COMPANY -> CompanyViewHolder.create(glide, parent, gotoCompanyDetail)
            TYPE_REVIEW -> CompanyReviewViewHolder.create(glide, parent)
            TYPE_THEME -> CompanyThemeViewHolder.create(glide, parent)
            else -> throw NullPointerException("Response is Null")
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = searchCellTypeList[position]) {
            is SearchCellTypeEntity.Company -> (holder as CompanyViewHolder).bind(item.data)
            is SearchCellTypeEntity.Review -> (holder as CompanyReviewViewHolder).bind(item.data)
            is SearchCellTypeEntity.HorizontalTheme -> (holder as CompanyThemeViewHolder).bind(item.data)
            else -> SearchCellTypeEntity.None
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (searchCellTypeList[position]) {
            is SearchCellTypeEntity.Company -> TYPE_COMPANY
            is SearchCellTypeEntity.Review -> TYPE_REVIEW
            is SearchCellTypeEntity.HorizontalTheme -> TYPE_THEME
            else -> TYPE_NONE
        }
    }

    override fun getItemCount(): Int {
        return searchCellTypeList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<SearchCellTypeEntity>) {
        searchCellTypeList = items
        notifyDataSetChanged()
    }

    companion object {
        const val TYPE_NONE = -1
        const val TYPE_COMPANY = 0
        const val TYPE_THEME = 1
        const val TYPE_REVIEW = 2
    }

}