package com.example.chucknorris.data.repository

import android.util.Log
import com.example.chucknorris.data.model.JokesRandom
import com.example.chucknorris.data.model.SearchFacts
import com.example.chucknorris.data.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryApi {

//    fun getJokesRandom(onSuccess:(data:List<JokesRandom>) -> Unit, onFailed:(message:String)-> Unit){
//        NetworkClient.instance.fetchRandomJokes(category = ).enqueue(object : Callback<JokesRandom>{
//            override fun onResponse(call: Call<JokesRandom>, response: Response<JokesRandom>) {
//                if (response.code()==200){
//                    val data = response.body()
//                    onSuccess(data)
//                }
//            }
//        })
//    }

    fun showDataWithQuery(query:String, responseHandler:(SearchFacts)-> Unit, errorHandler:(Throwable)-> Unit){
        NetworkClient.instance.fetchResultFilter(query = query).enqueue(object : Callback<SearchFacts>{
            override fun onResponse(call: Call<SearchFacts>, response: Response<SearchFacts>) {
                if (response.isSuccessful){
                    responseHandler(response.body()!!)
                    Log.d("ResponseData", responseHandler.toString())
                }
            }

            override fun onFailure(call: Call<SearchFacts>, t: Throwable) {
                errorHandler(t)
                Log.d("errorData", errorHandler.toString())
            }
        })
    }
}