package com.example.publicapi

import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

@RunWith(MockitoJUnitRunner::class)
class PublicTransportationRouteTest {


    @Mock
    lateinit var context: Context


    object Retrofit {
        inline fun <reified T> create(baseUrl: String): T =
            retrofit2.Retrofit.Builder()
                .addConverterFactory(JaxbConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
                .create(T::class.java)
    }
}


interface StationPathInfoApi {

    @GET("getLocationInfo")
    fun getLocationInfo(
        @Query("ServiceKey") serviceKey: String = "wQbwcnkjCD4ZrbNQHdNvC7TA2zodgF%2BDIY2krWGi3yKKjodyMg6YSX07dHYvjDt3pSUaQRWrFoTYmqGrU9m%2Fgw%3D%3D",
        @Query("stSrch", encoded = true) stSrch: String
    ): Call<LocationInfoResponse>

}


data class LocationInfoResponse(
    val comMsgHeader: String? = null,
    val msgHeader: LocationInfoMsgHeader? = null,
    val locationInfoList: List<LocationInfoItem>? = arrayListOf()
)
data class LocationInfoItem(
    val posX: String,
    val posY: String,
    val poiNm: String,
    val poiId: String,
    val gpsX: String,
    val gpsY: String
)
data class LocationInfoMsgHeader(
    val headerCd: String,
    val headerMsg: String,
    val itemCount: String,
)