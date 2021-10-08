package com.jydev.jobplanetandroid.ui.searchresult.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.databinding.ItemCompanyBinding
import com.jydev.jobplanetandroid.databinding.ItemCompanyReviewBinding
import com.jydev.jobplanetandroid.models.entity.search.ItemHeaderEntity
import com.jydev.jobplanetandroid.models.entity.search.ReviewCellTypeEntity
import com.jydev.jobplanetandroid.ui.BaseViewHolder

class CompanyReviewViewHolder(
    private val glide: RequestManager,
    private val view: ItemCompanyReviewBinding
) : BaseViewHolder<ReviewCellTypeEntity>(view.root) {
    override fun bind(item: ReviewCellTypeEntity) {
        with(view) {
            reviewCellTypeEntity = item
            itemHeaderEntity = ItemHeaderEntity(
                item.logoPath,
                item.companyName,
                item.industryName,
                item.rateTotalAvg,
                item.reviewSummary
            )
            with(itemHeader) {
                glide.load(item.logoPath)
                    .into(logoImageView)
            }
        }
    }

    companion object {
        fun create(
            glide: RequestManager,
            parent: ViewGroup
        ): CompanyReviewViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCompanyReviewBinding.inflate(layoutInflater, parent, false)
            return CompanyReviewViewHolder(glide, binding)
        }
    }
}