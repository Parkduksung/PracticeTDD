package com.jydev.jobplanetandroid.models.entity.search

import android.os.Parcelable
import com.jydev.jobplanetandroid.models.entity.Entity
import kotlinx.android.parcel.Parcelize

data class HorizontalThemeCellTypeEntity(val totalSize : Int, val themes : List<ThemeEntity>) :
    Entity
@Parcelize
data class ThemeEntity(val id : Int,val color : String, val coverImageUrl : String , val title : String) : Parcelable