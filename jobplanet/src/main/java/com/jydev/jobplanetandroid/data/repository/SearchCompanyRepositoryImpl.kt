package com.jydev.jobplanetandroid.data.repository

import com.jydev.jobplanetandroid.data.datasource.SearchCompanyDataSource
import com.jydev.jobplanetandroid.models.dto.search.SearchCellTypeDTO.Companion.toEntity
import com.jydev.jobplanetandroid.models.entity.search.SearchCompanyEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SearchCompanyRepositoryImpl @Inject constructor(private val dataSource: SearchCompanyDataSource) : SearchCompanyRepository {
    override fun getSearchCompanyList(): Single<SearchCompanyEntity> {
        return dataSource.getSearchCompanyList().map {
            SearchCompanyEntity(it.minimumInterviews,it.totalPage,it.minimumReviews,it.totalCount,it.items.map { DTO ->
                DTO.toEntity()
            })
        }
    }
}