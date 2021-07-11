package com.example.chucknorris.data.network

import com.example.chucknorris.data.model.Category
import com.example.chucknorris.data.model.JokesRandom
import com.example.chucknorris.data.model.SearchFacts
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories")
    fun fetchCategories() : Call<JokesRandom>

    @GET("random")
    fun fetchRandomJokes(
        @Query("category")category: String): Call<JokesRandom>

    @GET("search")
    fun fetchResultFilter(
        @Query("query") query : String) : Call<SearchFacts>

}