package com.example.kakaoapi.searchbook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kakaoapi.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

class SearchBookActivity : AppCompatActivity(R.layout.activity_search) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RetrofitUtil.createKakaoApi().searchBook(query = "코틀린")
            .enqueue(object : Callback<KakaoSearchBookResponse> {


                override fun onResponse(
                    call: Call<KakaoSearchBookResponse>,
                    response: Response<KakaoSearchBookResponse>
                ) {
                    response.body()?.let {
                        it.documents.forEach {
                            Log.d("결과", it.contents)
                        }
                    }
                }

                override fun onFailure(call: Call<KakaoSearchBookResponse>, t: Throwable) {
                    Log.d("결과", t.message.toString())
                }
            })


    }


}

object RetrofitUtil {
    private const val BASE_URL = "https://dapi.kakao.com/"

    fun createKakaoApi(): KakaoApi =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(KakaoApi::class.java)

}

interface KakaoApi {

    companion object {
        private const val REST_API_KEY = "7f0bc613532236da7fe88cf3b1bc3160"
        private const val SEARCH_BOOK = "v3/search/book"
    }

    @Headers("Authorization: KakaoAK $REST_API_KEY")
    @GET(SEARCH_BOOK)
    fun searchBook(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 50,
    ): Call<KakaoSearchBookResponse>

}
