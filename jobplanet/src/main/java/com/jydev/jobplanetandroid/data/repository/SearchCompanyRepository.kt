package com.jydev.jobplanetandroid.data.repository

import com.jydev.jobplanetandroid.models.entity.search.SearchCompanyEntity
import io.reactivex.rxjava3.core.Single

interface SearchCompanyRepository {
    fun getSearchCompanyList() : Single<SearchCompanyEntity>
}