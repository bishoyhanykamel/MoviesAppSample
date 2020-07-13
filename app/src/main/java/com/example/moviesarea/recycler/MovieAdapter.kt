package com.example.moviesarea.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesarea.MovieDetails
import com.example.moviesarea.databinding.ItemMovieLayoutBinding
import com.example.moviesarea.models.Movie
import com.squareup.picasso.Picasso


class MovieAdapter(val context: Context, val list: List<Movie>, val recentList: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieItem>() {

    init {
        setHasStableIds(true)
    }

    private lateinit var binding: ItemMovieLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemMovieLayoutBinding.inflate(layoutInflater, parent, false)
        return MovieItem(binding.root)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MovieItem, position: Int) {
        holder.bindData(list[position])
    }

    // ==========================================================================================\\
    inner class MovieItem(movieView: View) : RecyclerView.ViewHolder(movieView) {
        fun bindData(movie: Movie) {
            movie.vote_average = movie.vote_average / 2.0f
            binding.movieNameTextView.text = movie.title
            binding.movieRateRatingBar.root.rating = movie.vote_average
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/${movie.poster_path}")
                .into(binding.movieImageView)

            binding.root.setOnClickListener {
                val intent = Intent(context, MovieDetails::class.java)
                intent.putExtra("poster_path", movie.poster_path)
                intent.putExtra("name", movie.title)
                intent.putExtra("movie_overview", movie.overview)
                intent.putExtra("average_rate", movie.vote_average)
                context.startActivity(intent)
            }
            if (recentList.contains(movie))
                recentList.remove(movie)

            recentList.add(0,movie)
        }
    }

}