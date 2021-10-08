package com.jydev.jobplanetandroid.di

import com.jydev.jobplanetandroid.data.datasource.SearchCompanyDataSource
import com.jydev.jobplanetandroid.data.datasource.SearchCompanyDataSourceImpl
import com.jydev.jobplanetandroid.data.repository.SearchCompanyRepository
import com.jydev.jobplanetandroid.data.repository.SearchCompanyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindSearchCompanyRepository(searchCompanyRepositoryImpl: SearchCompanyRepositoryImpl): SearchCompanyRepository
}