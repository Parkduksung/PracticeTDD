package com.jydev.jobplanetandroid.models.entity.search

sealed class SearchCellTypeEntity {
    data class Company(val data: CompanyCellTypeEntity) : SearchCellTypeEntity()
    data class HorizontalTheme(val data: HorizontalThemeCellTypeEntity) : SearchCellTypeEntity()
    data class Review(val data: ReviewCellTypeEntity) : SearchCellTypeEntity()
    object None : SearchCellTypeEntity()
}