package com.jydev.jobplanetandroid.models.entity.search

import com.jydev.jobplanetandroid.models.entity.Entity

data class SearchCompanyEntity(val minimumInterviews : Int,
                               val totalPage : Int,
                               val minimumReviews : Int,
                               val totalCount : Int,
                               val items : List<SearchCellTypeEntity>): Entity