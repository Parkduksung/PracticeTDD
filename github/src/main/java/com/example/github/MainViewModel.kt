package com.example.github

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(app: Application) : AndroidViewModel(app) {

    val inputUserLiveData = MutableLiveData<String>()


    private val _mainViewStateLiveData = MutableLiveData<MainViewState>()
    val mainViewStateLiveData: LiveData<MainViewState> = _mainViewStateLiveData

    fun search() {
        inputUserLiveData.value?.let {
            getSearchUser(it)
        }
    }

    private fun getSearchUser(userId: String) {

        Retrofit.create<GithubApi>("https://api.github.com/").getGithubUser(q = userId)
            .enqueue(object :
                Callback<GithubResponse> {
                override fun onResponse(
                    call: Call<GithubResponse>,
                    response: Response<GithubResponse>
                ) {

                    if (response.body() != null) {
                        _mainViewStateLiveData.value =
                            MainViewState.GetSearchResult(response.body()!!.items)
                    } else {
                        _mainViewStateLiveData.value = MainViewState.Error("예기지 못한 에러 발생.")
                    }

                }

                override fun onFailure(call: Call<GithubResponse>, t: Throwable) {
                    _mainViewStateLiveData.value = MainViewState.Error(t.message.toString())
                }
            })
    }


    sealed class MainViewState {
        data class GetSearchResult(val list: List<GithubItem>) : MainViewState()
        data class Error(val message: String) : MainViewState()
    }
}