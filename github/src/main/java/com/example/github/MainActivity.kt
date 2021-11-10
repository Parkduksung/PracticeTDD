package com.example.github

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val githubAdapter by lazy { GithubAdapter() }

    private val mainViewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    return MainViewModel(application) as T
                } else throw IllegalAccessException()
            }
        }).get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initViewModel()
    }

    private fun initUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        binding.rvUser.run {
            adapter = githubAdapter
        }

    }

    private fun initViewModel() {

        binding.viewModel = mainViewModel

        mainViewModel.mainViewStateLiveData.observe(this) { viewState ->
            when (viewState) {
                is MainViewModel.MainViewState.GetSearchResult -> {
                    githubAdapter.clear()
                    githubAdapter.addAll(viewState.list)
                }

                is MainViewModel.MainViewState.Error -> {
                    githubAdapter.clear()
                    Toast.makeText(this, viewState.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}