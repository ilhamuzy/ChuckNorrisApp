package com.example.chucknorris.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorris.data.model.SearchFacts
import com.example.chucknorris.data.repository.RepositoryApi

class MainViewModel : ViewModel() {

    val resultJokes = MutableLiveData<SearchFacts>()

    val repositoryApi = RepositoryApi()

    val error = MutableLiveData<Throwable>()

    fun fetchResult(query : String){
        repositoryApi.showDataWithQuery(query = query,
            {
                resultJokes.value = it
            },
            {
                error.value = it
            }
            )
    }
}