package com.example.chucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorris.data.model.SearchFacts
import com.example.chucknorris.util.StateResponse
import com.example.chucknorris.util.Status
import com.example.chucknorris.view.JokesAdapter
import com.example.chucknorris.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var jokesViewModel : MainViewModel

    lateinit var jokesAdapter: JokesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShuffle.setOnClickListener {
            getRandomFact()
        }

        jokesViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        jokesViewModel.fetchResult(query = "kid")

        jokesViewModel.resultJokes.observe(this, Observer {
            Log.d("message", it.result.toString())
        })
        jokesViewModel.error.observe(this, Observer {
            Log.d("error", it.message.toString())
        })
    }

    private fun getRandomFact(){
        runOnUiThread {
            pbMain.visibility = View.VISIBLE
        }
    }
    override fun onStart() {
        super.onStart()
        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        jokesAdapter = JokesAdapter(arrayListOf())
        rvMain.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = jokesAdapter
        }
    }

    private fun showData(data: SearchFacts){
        val results = data.result
        jokesAdapter.setData(data)
    }
}