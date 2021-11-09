package com.example.github

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    private fun getSearchUser(userId: String) {

        Retrofit.create<GithubApi>("https://api.github.com/").getGithubUser(q = userId)
            .enqueue(object :
                Callback<GithubResponse> {
                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {
                    Log.d("결과", "onResponse")

                    response.body()?.let { result ->
                        result.items.forEach {
                            Log.d("결과", it.url)
                            Log.d("결과", it.id.toString())
                            Log.d("결과", it.score.toString())
                            Log.d("결과", it.html_url)
                            Log.d("결과", it.repos_url)
                        }
                    }
                }
                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    Log.d("결과", t.message.toString())
                }
            })


    }

}