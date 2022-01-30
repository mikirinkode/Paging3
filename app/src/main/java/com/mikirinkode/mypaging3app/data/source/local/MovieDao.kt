package com.mikirinkode.mypaging3app.data.source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mikirinkode.mypaging3app.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_entities")
    fun getAllImages(): PagingSource<Int, Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>)

    @Query("DELETE FROM movie_entities")
    suspend fun deleteAllMovies()
}