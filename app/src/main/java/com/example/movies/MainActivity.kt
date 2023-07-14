package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter : MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()
        val movieName : String = binding.editText.text.toString()

        /**
         * I tried to work with this code,it is getting error
         */
        /*binding.searchButton.setOnClickListener{
            viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
                movieList.forEach {
                    val searchData = it.title
                    if(searchData.equals(movieName)){
                        movieAdapter.setMovieList(movieList)
                    }
                }
             })
        }*/
        viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
                    movieAdapter.setMovieList(movieList)
        })
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.movieRecycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = movieAdapter
        }
    }



}
