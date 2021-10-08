package com.jydev.jobplanetandroid.di

import com.google.gson.GsonBuilder
import com.jydev.jobplanetandroid.data.JobPlanetService
import com.jydev.jobplanetandroid.models.response.SearchCompanyResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://jpassets.jobplanet.co.kr/"

    @Singleton
    @Provides
    fun provideJobPlanetService(retrofit: Retrofit): JobPlanetService {
        return retrofit.create(JobPlanetService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().registerTypeAdapter(
                        SearchCompanyResponse::class.java,
                        SearchCompanyResponse.SearchCompanyResponseDeserializer()
                    ).create()
                )
            ).build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }).build()
    }

}