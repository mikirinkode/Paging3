package com.mikirinkode.mypaging3app.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mikirinkode.mypaging3app.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}