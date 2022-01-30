package com.mikirinkode.mypaging3app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val results: List<Movie>
)

@Entity(tableName = "movie_entities")
data class Movie(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("backdrop_path")
    val backdropPath: String
)
