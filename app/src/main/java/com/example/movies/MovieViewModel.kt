package com.example.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.api.RetrofitInstance
import com.example.movies.model.MovieResponse
import com.example.movies.model.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel :  ViewModel() {
    private var movieLiveData = MutableLiveData<List<ResultData>>()

    fun getPopularMovies() {
        RetrofitInstance.api.getMovieList("arGiw6O4PtmshRnu6VGgrcJiO3DJp1cuMVojsnEABg5WRSaZVu","imdb8.p.rapidapi.com","game").enqueue(object  :
            Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<ResultData>> {
        return movieLiveData
    }
}