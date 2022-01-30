package com.mikirinkode.mypaging3app.data.source.remote

import com.mikirinkode.mypaging3app.BuildConfig
import com.mikirinkode.mypaging3app.model.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular?api_key=$API_KEY")
    suspend fun getAllMovies(
        @Query("page") page: Int
    ): List<Movie>

    companion object {
        const val API_KEY = BuildConfig.TMDB_API_KEY
    }
}