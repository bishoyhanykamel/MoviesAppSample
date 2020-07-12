package com.example.moviesarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.moviesarea.databinding.ActivityMainBinding
import com.example.moviesarea.models.Movie
import com.example.moviesarea.recycler.MovieAdapter

class MainActivity : AppCompatActivity() {

    private val API_KEY = "fcc41d51768165fb5baffadb846dfb71"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setting up viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting the adapter for the recycler view
        binding.mainRecyclerView.adapter = MovieAdapter(getMoviesList())

        // Setting the toolbar for the app to use the overridden functions
        setSupportActionBar(binding.mainToolbar)
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

    // inflating the menu into the toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movie_view_menu, menu)
        return true
    }

    // function that specifies onClicks for menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mostViewed_menuItem -> {
                Toast.makeText(this, "Most viewed movies", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.topRated_menuItem -> {
                Toast.makeText(this, "Top rated movies", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.recentlyViewed_menuItem -> {
                Toast.makeText(this, "Recently viewed", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}