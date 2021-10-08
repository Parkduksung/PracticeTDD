package com.jydev.jobplanetandroid.models.dto

import com.jydev.jobplanetandroid.models.entity.Entity

interface BaseDTO<T : Entity> {
    fun toEntity() : T
}