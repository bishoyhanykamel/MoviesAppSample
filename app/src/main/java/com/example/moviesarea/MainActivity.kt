package com.example.moviesarea

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesarea.databinding.ActivityMainBinding
import com.example.moviesarea.models.Movie
import com.example.moviesarea.models.MovieResponse
import com.example.moviesarea.network.ApiService
import com.example.moviesarea.network.RetrofitClient
import com.example.moviesarea.recycler.MovieAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    // ========================= [ VARIABLE DECLARATIONS] =========================================
    private val API_KEY = "fcc41d51768165fb5baffadb846dfb71"
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService: ApiService
    private var topRatedMovies: List<Movie> = listOf<Movie>()
    private var popularMovies: List<Movie> = listOf<Movie>()


    // ========================= [ OVERRIDEN FUNCTIONS] ===========================================
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setting up viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setting the API and retrofit data
        apiService = RetrofitClient.getRetrofitClient().create(ApiService::class.java)
        initTopRated()
        initPopularMovies()

        // Setting the toolbar for the app to use the overridden functions
        setSupportActionBar(binding.mainToolbar)

        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    // inflating the menu into the toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_view_menu, menu)
        return true
    }

    // function that specifies onClicks for menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mostViewed_menuItem -> {
                displayMovieList(popularMovies)
                true
            }
            R.id.topRated_menuItem -> {
                displayMovieList(topRatedMovies)
                true
            }
            R.id.recentlyViewed_menuItem -> {
                Toast.makeText(this, "Recently viewed", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    // ========================= [ CUSTOM FUNCTIONS] ==============================================
    // function to get popular movies in a list
    private fun initPopularMovies() {
        apiService.getPopular(API_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("MainActivity.kt", "Error processing initPopularMovies function")
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    popularMovies = response.body()?.results ?: listOf<Movie>()
                }
            }
        })
    }

    // function to get top rated movies in a list
    private fun initTopRated() {
        apiService.getTopRated(API_KEY).enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    topRatedMovies = response.body()?.results ?: listOf<Movie>()
                    displayMovieList(topRatedMovies)
                }
            }
        })
    }

    // Setting the adapter for the recycler view with a specified list of movies
    private fun displayMovieList(list: List<Movie>) {
        binding.mainRecyclerView.adapter = MovieAdapter(this, list)
    }
}