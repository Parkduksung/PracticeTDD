package com.example.publicapi

import okhttp3.Request
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

@RunWith(MockitoJUnitRunner::class)
class GoCampingTest {


    @Mock
    lateinit var goCampingApi: GoCampingApi

    /**
     * 한국관광공사 고캠핑 Api Operation Type
     * baseList - 기본 정보 목록 조회
     * locationBasedList - 위치기반 정보 목록 조회
     * searchList - 키워드 검색 목록 조회
     * imageList - 이미지정보 목록 조회
     */

    @Test
    fun checkBaseListSuccessTest() {
        val getBaseList = Retrofit.create<GoCampingApi>(GOCAPMING_BASE_URL).getBaseList()

    }


    private fun mockGetBaseListPublicApi() {

        Mockito.`when`(goCampingApi.getBaseList()).thenReturn(
            object : Call<GoCampingResponse> {
                override fun execute(): Response<GoCampingResponse> {
                    return Response.success(mockBaseListResponse)
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
            }
        )
    }

    companion object {
        private const val GOCAPMING_BASE_URL =
            "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/"

        private val mockBaseListResponse =
            GoCampingResponse(
                Response(
                    Body(
                        Items(
                            listOf(
                                Item(
                                    "",
                                    0,
                                    "",
                                    0,
                                    "",
                                    "",
                                    "",
                                    0,
                                    "",
                                    0,
                                    "",
                                    "",
                                    "",
                                    0,
                                    "",
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    "",
                                    0,
                                    "",
                                    0,
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    0,
                                    "",
                                    0,
                                    "",
                                    0,
                                    0
                                )
                            )
                        ), 30, 1,
                        30
                    ),
                    Header("200", "")
                )
            )
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

interface GoCampingApi {


    companion object {
        private const val GO_CAMPING_KEY =
            "R2RhdScz9hCftK1V5Ouq1pbZYgwUN5DYGpryUpEaaqb5XbqD0putXtCzB7GQ1y1F2fAzzD5c%2BkT8lD4E3nSQ1g%3D%3D"

        private const val MOBILE_OS = "AND"

        private const val MOBILE_APP = "CarCamping"

        private const val BASE_LIST_URL = "basedList"

        private const val TYPE_JSON = "json"

    }


    @GET(BASE_LIST_URL)
    fun getBaseList(
        @Query("ServiceKey") serviceKey: String = GO_CAMPING_KEY,
        @Query("MobileOS") mobileOS: String = MOBILE_OS,
        @Query("MobileApp") MobileApp: String = MOBILE_APP,
        @Query("_type") _type: String = TYPE_JSON
    ): Call<GoCampingResponse>

}

data class GoCampingResponse(
    val response: com.example.publicapi.Response
)

data class Response(
    val body: Body,
    val header: Header
)


data class Header(
    val resultCode: String,
    val resultMsg: String
)

data class Body(
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)

data class Items(
    val item: List<Item>
)


data class Item(
    val addr1: String,
    val allar: Int,
    val animalCmgCl: String,
    val autoSiteCo: Int,
    val bizrno: String,
    val brazierCl: String,
    val caravAcmpnyAt: String,
    val caravSiteCo: Int,
    val clturEventAt: String,
    val contentId: Int,
    val createdtime: String,
    val doNm: String,
    val exprnProgrmAt: String,
    val extshrCo: Int,
    val facltNm: String,
    val fireSensorCo: Int,
    val frprvtSandCo: Int,
    val frprvtWrppCo: Int,
    val glampSiteCo: Int,
    val gnrlSiteCo: Int,
    val induty: String,
    val indvdlCaravSiteCo: Int,
    val insrncAt: String,
    val manageNmpr: Int,
    val manageSttus: String,
    val mangeDivNm: String,
    val mapX: Any,
    val mapY: Any,
    val modifiedtime: String,
    val operDeCl: String,
    val operPdCl: String,
    val prmisnDe: String,
    val sigunguNm: String,
    val siteBottomCl1: Int,
    val siteBottomCl2: Int,
    val siteBottomCl3: Int,
    val siteBottomCl4: Int,
    val siteBottomCl5: Int,
    val siteMg1Co: Int,
    val siteMg1Vrticl: Int,
    val siteMg1Width: Int,
    val siteMg2Co: Int,
    val siteMg2Vrticl: Int,
    val siteMg2Width: Int,
    val siteMg3Co: Int,
    val siteMg3Vrticl: Int,
    val siteMg3Width: Int,
    val sitedStnc: Int,
    val swrmCo: Int,
    val tel: String,
    val toiletCo: Int,
    val trlerAcmpnyAt: String,
    val wtrplCo: Int,
    val zipcode: Int
)