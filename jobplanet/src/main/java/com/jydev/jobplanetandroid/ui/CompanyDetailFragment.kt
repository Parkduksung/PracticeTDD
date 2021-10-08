package com.jydev.jobplanetandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jydev.jobplanetandroid.R
import com.jydev.jobplanetandroid.databinding.FragmentCompanyDetailBinding
import com.jydev.jobplanetandroid.models.entity.search.ItemHeaderEntity


class CompanyDetailFragment :
    BaseFragment<FragmentCompanyDetailBinding>(R.layout.fragment_company_detail) {
    private val args: CompanyDetailFragmentArgs by navArgs()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCompanyDetailBinding {
        return FragmentCompanyDetailBinding.inflate(inflater, container, false)
    }

    override fun setUpView() {
        with(binding) {
            (args.companyCellTypeEntity).let {
                companyCellTypeEntity = it
                itemHeaderEntity = ItemHeaderEntity(
                    it.logoPath,
                    it.companyName,
                    it.industryName,
                    it.rateTotalAvg,
                    it.reviewSummary
                )
            }
        }
    }
}