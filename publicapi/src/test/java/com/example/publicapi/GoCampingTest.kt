package com.example.publicapi

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(MockitoJUnitRunner::class)
class GoCampingTest {


    /**
     * 한국관광공사 고캠핑 Api Operation Type
     * baseList - 기본 정보 목록 조회
     * locationBasedList - 위치기반 정보 목록 조회
     * searchList - 키워드 검색 목록 조회
     * imageList - 이미지정보 목록 조회
     */

    @Test
    fun checkBaseListSuccessTest() {
        val goCampingApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/")
            .build()
            .create(PublicApi::class.java)
    }


}