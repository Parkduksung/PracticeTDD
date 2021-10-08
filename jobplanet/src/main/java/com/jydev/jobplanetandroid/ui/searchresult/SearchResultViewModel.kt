package com.jydev.jobplanetandroid.ui.searchresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jydev.jobplanetandroid.data.repository.SearchCompanyRepository
import com.jydev.jobplanetandroid.models.entity.search.SearchCellTypeEntity
import com.jydev.jobplanetandroid.models.entity.search.SearchCompanyEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(private val repository: SearchCompanyRepository) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private var _searchResult = MutableLiveData<SearchResult>()
    val searchResult: LiveData<SearchResult>
        get() = _searchResult

    fun getSearchCompanyList() {
        repository.getSearchCompanyList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _searchResult.value = SearchResult.Success(it.items)
            }, { throwable ->
                throwable.message?.let {
                    _searchResult.value = SearchResult.Error(it)
                }
            }).addToComposite()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    private fun Disposable.addToComposite() {
        compositeDisposable.add(this)
    }

    sealed class SearchResult{
        data class Error(val errorMessage : String) : SearchResult()
        data class Success(val searchCompanyEntity: List<SearchCellTypeEntity>) : SearchResult()
    }
}