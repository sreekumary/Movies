package com.example.movies.model

data class ResultData(
    val episode: Int,
    val id: String,
    val image: Image,
    val nextEpisode: String,
    val numberOfEpisodes: Int,
    val parentTitle: ParentTitle,
    val previousEpisode: String,
    val principals: List<Principal>,
    val runningTimeInMinutes: Int,
    val season: Int,
    val seriesEndYear: Int,
    val seriesStartYear: Int,
    val title: String,
    val titleType: String,
    val year: Int
)