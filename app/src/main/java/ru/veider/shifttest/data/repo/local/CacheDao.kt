package ru.veider.shifttest.data.repo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.veider.shifttest.data.repo.local.data.CacheData

@Dao
interface CacheDao {

    @Query("SELECT * FROM CacheData")
    suspend fun getCache(): List<CacheData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putCache(card: CacheData)
}