package com.example.chucknorris.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import com.example.chucknorris.data.model.JokesRandom
import com.example.chucknorris.data.model.SearchFacts
import kotlinx.android.synthetic.main.item_main_jokes.view.*

class JokesAdapter(val results : ArrayList<SearchFacts>)
    : RecyclerView.Adapter<JokesAdapter.viewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  viewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_main_jokes, parent, false)
    )

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val result = results[position]
        holder.view.tvMainJokes.text = results.toString()
    }

    override fun getItemCount(): Int = results.size
    class viewHolder (val view: View) : RecyclerView.ViewHolder(view)

    fun setData(data: SearchFacts){
        results.clear()
        results.addAll(listOf(data))
        notifyDataSetChanged()
    }
}