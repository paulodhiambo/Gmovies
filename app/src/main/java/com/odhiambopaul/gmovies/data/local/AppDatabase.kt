package com.odhiambopaul.gmovies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.odhiambopaul.gmovies.domain.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}