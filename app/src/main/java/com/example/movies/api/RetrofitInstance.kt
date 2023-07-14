package com.example.movies.api

import com.example.movies.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

   /* private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()*/


    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }



}