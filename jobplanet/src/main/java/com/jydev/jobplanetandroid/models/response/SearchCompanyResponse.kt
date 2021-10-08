package com.jydev.jobplanetandroid.models.response

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import com.jydev.jobplanetandroid.models.dto.search.SearchCellTypeDTO
import com.jydev.jobplanetandroid.models.dto.search.CompanyCellTypeDTO
import com.jydev.jobplanetandroid.models.dto.search.HorizontalThemeCellTypeDTO
import com.jydev.jobplanetandroid.models.dto.search.ReviewCellTypeDTO
import java.lang.NullPointerException
import java.lang.reflect.Type

data class SearchCompanyResponse(
    @SerializedName("minimum_interviews")
    val minimumInterviews : Int,
    @SerializedName("total_page")
    val totalPage : Int,
    @SerializedName("minimum_reviews")
    val minimumReviews : Int,
    @SerializedName("total_count")
    val totalCount : Int,
    val items : List<SearchCellTypeDTO>
){
    class SearchCompanyResponseDeserializer : JsonDeserializer<SearchCompanyResponse> {
        private val gson = Gson()
        override fun deserialize(
            json: JsonElement?,
            typeOfT: Type?,
            context: JsonDeserializationContext?
        ): SearchCompanyResponse {
            val jsonObject = json?.asJsonObject ?: throw NullPointerException("Response is Null")
            val minimumInterviews = jsonObject["minimum_interviews"].asInt
            val totalPage = jsonObject["total_page"].asInt
            val minimumReviews = jsonObject["minimum_reviews"].asInt
            val totalCount = jsonObject["total_count"].asInt
            val items = jsonObject["items"].asJsonArray.map {
                val cellType = it.asJsonObject["cell_type"].asString
                getSearchCellType(cellType,it)
            }
            return SearchCompanyResponse(minimumInterviews,totalPage,minimumReviews,totalCount,items)
        }

        private fun getSearchCellType(cellType: String, data : JsonElement) : SearchCellTypeDTO {
            return when(cellType){
                SearchCellTypeDTO.CELL_TYPE_COMPANY -> {
                    SearchCellTypeDTO.Company(gson.fromJson(data,CompanyCellTypeDTO::class.java))
                }
                SearchCellTypeDTO.CELL_TYPE_HORIZONTAL_THEME -> {
                    SearchCellTypeDTO.HorizontalTheme(gson.fromJson(data,HorizontalThemeCellTypeDTO::class.java))
                }
                SearchCellTypeDTO.CELL_TYPE_REVIEW -> {
                    SearchCellTypeDTO.Review(gson.fromJson(data,ReviewCellTypeDTO::class.java))
                }
                else -> SearchCellTypeDTO.None
            }
        }
    }
}