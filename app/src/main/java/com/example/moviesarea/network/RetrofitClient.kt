package com.example.moviesarea.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var client: Retrofit? = null

    fun getRetrofitClient(): Retrofit {
        if (client == null)
            client =
                Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        return client!!
    }
}