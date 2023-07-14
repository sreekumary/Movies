package com.example.movies.model

data class Principal(
    val `as`: String,
    val attr: List<String>,
    val billing: Int,
    val category: String,
    val characters: List<String>,
    val disambiguation: String,
    val endYear: Int,
    val episodeCount: Int,
    val id: String,
    val legacyNameText: String,
    val name: String,
    val roles: List<Role>,
    val startYear: Int
)