package com.jydev.jobplanetandroid.models.dto.search

import com.jydev.jobplanetandroid.models.entity.search.SearchCellTypeEntity

sealed class SearchCellTypeDTO {
    data class Company(val data: CompanyCellTypeDTO) : SearchCellTypeDTO()
    data class HorizontalTheme(val data: HorizontalThemeCellTypeDTO) : SearchCellTypeDTO()
    data class Review(val data: ReviewCellTypeDTO) : SearchCellTypeDTO()

    object None : SearchCellTypeDTO()

    companion object {
        const val CELL_TYPE_COMPANY = "CELL_TYPE_COMPANY"
        const val CELL_TYPE_HORIZONTAL_THEME = "CELL_TYPE_HORIZONTAL_THEME"
        const val CELL_TYPE_REVIEW = "CELL_TYPE_REVIEW"
        fun SearchCellTypeDTO.toEntity() : SearchCellTypeEntity{
            return when(this){
                is Company -> SearchCellTypeEntity.Company(data.toEntity())
                is HorizontalTheme -> SearchCellTypeEntity.HorizontalTheme(data.toEntity())
                is Review -> SearchCellTypeEntity.Review(data.toEntity())
                else -> SearchCellTypeEntity.None
            }
        }
    }
}
