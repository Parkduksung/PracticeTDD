package com.jydev.jobplanetandroid.ui.searchresult.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.jydev.jobplanetandroid.databinding.ItemCompanyBinding
import com.jydev.jobplanetandroid.models.entity.search.CompanyCellTypeEntity
import com.jydev.jobplanetandroid.models.entity.search.ItemHeaderEntity
import com.jydev.jobplanetandroid.ui.BaseViewHolder
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

class CompanyViewHolder(
    private val glide: RequestManager,
    private val view: ItemCompanyBinding,
    val gotoCompanyDetail: (CompanyCellTypeEntity) -> Unit
) : BaseViewHolder<CompanyCellTypeEntity>(view.root) {

    override fun bind(item: CompanyCellTypeEntity) {
        with(view) {
            companyCellTypeEntity = item
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
            lookMoreCompanyTextView.setOnClickListener {
                gotoCompanyDetail(item)
            }
        }
    }

    companion object {
        fun create(
            glide: RequestManager,
            parent: ViewGroup,
            gotoCompanyDetail: (CompanyCellTypeEntity) -> Unit
        ): CompanyViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCompanyBinding.inflate(layoutInflater, parent, false)
            return CompanyViewHolder(glide, binding, gotoCompanyDetail)
        }
    }

}