package com.example.movies.api

import com.example.movies.model.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApi {


    @GET("/title/find")
      fun getMovieList(@Header("X-RapidAPI-Key") key: String,
                             @Header("X-RapidAPI-Host") host: String,
                             @Query("q") query: String) : Call<MovieResponse>
}
