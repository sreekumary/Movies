package com.example.movies.model

data class MovieResponse(
    /*    val @meta: Meta,
        val @type: String,*/
    val query: String,
    val results: List<ResultData>,
    val types: List<String>
)