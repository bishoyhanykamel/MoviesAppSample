package com.example.moviesarea.network

import com.example.moviesarea.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String = "en-US"
    ): Call<MovieResponse>

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String = "en-US"
    ): Call<MovieResponse>

    @GET("movie/")
    fun getMovie(
        @Path("${movieId}") movieId: Int,
        @Query("api_key") apiKey: String
    )
}