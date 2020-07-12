package com.example.moviesarea.models

data class Movie(
    val poster_path: String,
    val overview: String,
    val title: String,
    var vote_average: Float
)