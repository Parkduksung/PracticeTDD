package com.jydev.jobplanetandroid.data

import com.jydev.jobplanetandroid.models.response.SearchCompanyResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface JobPlanetService {
    @GET("mobile-config/test_data.json")
    fun getSearchCompanyList() : Single<SearchCompanyResponse>
}