package com.example.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.databinding.RowLayoutBinding
import com.example.movies.model.ResultData

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList = ArrayList<ResultData>()
    fun setMovieList(movieList: List<ResultData>) {
        this.movieList = movieList as ArrayList<ResultData>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movieList[position].principals?.forEach {
            holder.binding.textView3.text = it.name
            holder.binding.textView4.text = it.category
            //holder.binding.textView5.text = it.startYear.toString()
            //holder.binding.textView6.text = it.roles[position].character
        }

        Glide.with(holder.itemView)
            .load(movieList[position].image.url)
            .into(holder.binding.imageMovie)
        holder.binding.txtTittle.text = movieList[position].title
        holder.binding.txtSeries.text = movieList[position].titleType


    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}