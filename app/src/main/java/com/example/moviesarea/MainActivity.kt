package com.example.moviesarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesarea.databinding.ActivityMainBinding
import com.example.moviesarea.models.Movie
import com.example.moviesarea.recycler.MovieAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.adapter = MovieAdapter(getMoviesList())
    }


    private fun getMoviesList(): List<Movie> {
        val list = ArrayList<Movie>()
        list.add(Movie("Shawshank Redepmtion", 5.0f))
        list.add(Movie("Shawshank Redepmtion", 4.5f))
        list.add(Movie("Shawshank Redepmtion", 3.5f))
        list.add(Movie("Shawshank Redepmtion", 3.0f))
        list.add(Movie("Shawshank Redepmtion", 2.4f))
        list.add(Movie("Shawshank Redepmtion", 2.0f))
        return list
    }
}