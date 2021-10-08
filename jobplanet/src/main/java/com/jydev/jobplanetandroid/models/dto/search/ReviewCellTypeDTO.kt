package com.jydev.jobplanetandroid.models.dto.search

import com.google.gson.annotations.SerializedName
import com.jydev.jobplanetandroid.models.dto.BaseDTO
import com.jydev.jobplanetandroid.models.entity.search.ReviewCellTypeEntity

data class ReviewCellTypeDTO(
    val ranking: Int,
    @SerializedName("cell_type")
    val cellType: String,
    val cons: String,
    val name: String,
    @SerializedName("days_ago")
    val daysAgo: Int,
    @SerializedName("logo_path")
    val logoPath: String,
    val pros: String,
    @SerializedName("company_id")
    val companyId: Int,
    @SerializedName("occupation_name")
    val occupationName: String,
    @SerializedName("rate_total_avg")
    val rateTotalAvg: Double,
    @SerializedName("industry_id")
    val industryId: Int,
    val date: String,
    @SerializedName("review_summary")
    val reviewSummary: String,
    val type: String,
    @SerializedName("industry_name")
    val industryName: String,
    @SerializedName("simple_desc")
    val simpleDesc: String
) : BaseDTO<ReviewCellTypeEntity> {
    override fun toEntity(): ReviewCellTypeEntity {
        return ReviewCellTypeEntity(
            companyId,
            industryId,
            ranking,
            logoPath,
            name,
            industryName,
            rateTotalAvg.toString(),
            reviewSummary,
            pros,
            cons
        )
    }

}