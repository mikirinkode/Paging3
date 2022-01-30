package com.mikirinkode.mypaging3app.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mikirinkode.mypaging3app.model.MovieRemoteKeys

@Dao
interface MovieRemoteKeysDao {
    @Query("SELECT * FROM movie_remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: String): MovieRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<MovieRemoteKeys>)

    @Query("DELETE FROM movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}