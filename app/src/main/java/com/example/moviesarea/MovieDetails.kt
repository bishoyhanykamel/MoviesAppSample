package com.example.moviesarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesarea.databinding.ActivityMovieDetailsBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.view.*

class MovieDetails : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting movie data from previous activity
        val imagePath = intent.getStringExtra("poster_path")
        val name = intent.getStringExtra("name")
        val overview = intent.getStringExtra("movie_overview")
        val rate = intent.getFloatExtra("average_rate", 0.0f)

        // loading movie data
        binding.movieNameTextView.text = name
        binding.movieOverviewTextView.text = overview
        binding.movieRateRatingBar.root.rating = rate
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${imagePath}")
            .into(binding.movieImageView)
    }
}