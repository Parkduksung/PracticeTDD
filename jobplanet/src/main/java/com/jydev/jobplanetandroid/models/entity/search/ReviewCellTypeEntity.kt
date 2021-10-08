package com.jydev.jobplanetandroid.models.entity.search

import com.jydev.jobplanetandroid.models.entity.Entity

data class ReviewCellTypeEntity(
    val companyId : Int,
    val industryId : Int,
    val ranking : Int,
    val logoPath : String,
    val companyName : String,
    val industryName : String,
    val rateTotalAvg : String,
    val reviewSummary : String,
    val pros : String,
    val cons : String
) : Entity