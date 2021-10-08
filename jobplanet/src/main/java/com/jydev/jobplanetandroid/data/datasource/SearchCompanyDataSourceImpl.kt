package com.jydev.jobplanetandroid.data.datasource

import com.jydev.jobplanetandroid.data.JobPlanetService
import com.jydev.jobplanetandroid.models.response.SearchCompanyResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchCompanyDataSourceImpl @Inject constructor(private val service: JobPlanetService) : SearchCompanyDataSource {
    override fun getSearchCompanyList(): Single<SearchCompanyResponse> {
        return service.getSearchCompanyList()
    }
}