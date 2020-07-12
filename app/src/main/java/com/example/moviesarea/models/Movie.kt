package com.example.moviesarea.models

import com.example.moviesarea.R

data class Movie(
    val name: String,
    val rating: Float,
    val imageRes: Int = R.drawable.ic_launcher_background
)