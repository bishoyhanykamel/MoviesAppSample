package com.example.moviesarea.models

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)