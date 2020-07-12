package com.example.moviesarea.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesarea.R
import com.example.moviesarea.databinding.ItemMovieLayoutBinding
import com.example.moviesarea.models.Movie


class MovieAdapter(val list: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieItem>() {

    private lateinit var binding: ItemMovieLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemMovieLayoutBinding.inflate(layoutInflater, parent, false)
        return MovieItem(binding.root)
    }

    override fun getItemCount(): Int
            = list.size

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        holder.bindData(list[position])
    }

    // ==========================================================================================\\
    inner class MovieItem(movieView: View): RecyclerView.ViewHolder(movieView) {
        fun bindData(movie: Movie) {
            binding.movieNameTextView.text = movie.name
            binding.movieRateRatingBar.rating = movie.rating
            binding.movieImageView.setImageResource(movie.imageRes)
        }
    }

}