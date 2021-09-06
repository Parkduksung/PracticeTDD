package com.example.publicapi

import okhttp3.Request
import okio.Timeout
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(MockitoJUnitRunner::class)
class GoCampingTest {


    @Mock
    lateinit var publicApi: PublicApi

    /**
     * 한국관광공사 고캠핑 Api Operation Type
     * baseList - 기본 정보 목록 조회
     * locationBasedList - 위치기반 정보 목록 조회
     * searchList - 키워드 검색 목록 조회
     * imageList - 이미지정보 목록 조회
     */

    @Test
    fun checkBaseListSuccessTest() {
        val goCampingApi = Retrofit.create<PublicApi>(GOCAPMING_BASE_URL)

    }


    private fun mockGetBaseListPublicApi() {

        Mockito.`when`(publicApi.getBaseList()).thenReturn(
            object : Call<GoCampingResponse> {
                override fun execute(): Response<GoCampingResponse> {
                    TODO("Not yet implemented")
                }

                override fun enqueue(callback: Callback<GoCampingResponse>) {
                    TODO("Not yet implemented")
                }

                override fun clone(): Call<GoCampingResponse> {
                    TODO("Not yet implemented")
                }

                override fun isExecuted(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun cancel() {
                    TODO("Not yet implemented")
                }

                override fun isCanceled(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun request(): Request {
                    TODO("Not yet implemented")
                }

                override fun timeout(): Timeout {
                    TODO("Not yet implemented")
                }
            }
        )
    }

    companion object {
        private const val GOCAPMING_BASE_URL =
            "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/"
    }

    object Retrofit {
        inline fun <reified T> create(baseUrl: String): T =
            retrofit2.Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(T::class.java)
    }
}