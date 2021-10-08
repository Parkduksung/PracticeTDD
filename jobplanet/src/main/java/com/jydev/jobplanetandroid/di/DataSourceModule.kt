package com.jydev.jobplanetandroid.di

import android.app.Activity
import com.jydev.jobplanetandroid.data.datasource.SearchCompanyDataSource
import com.jydev.jobplanetandroid.data.datasource.SearchCompanyDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindSearchCompanyDataSource(searchCompanyDataSourceImpl: SearchCompanyDataSourceImpl): SearchCompanyDataSource
}