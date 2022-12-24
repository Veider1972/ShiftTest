package ru.veider.shifttest.data.repo.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.veider.shifttest.data.repo.local.data.CacheData

@Database(entities = [CacheData::class], version = 1, exportSchema = false)
abstract class LocalDataBase: RoomDatabase() {
    abstract fun cacheDao(): CacheDao
}