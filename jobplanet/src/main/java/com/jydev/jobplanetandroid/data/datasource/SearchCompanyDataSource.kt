package com.jydev.jobplanetandroid.data.datasource

import com.jydev.jobplanetandroid.models.response.SearchCompanyResponse
import io.reactivex.rxjava3.core.Single

interface SearchCompanyDataSource {
    fun getSearchCompanyList() : Single<SearchCompanyResponse>
}