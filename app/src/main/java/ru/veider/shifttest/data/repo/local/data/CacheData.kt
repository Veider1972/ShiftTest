package ru.veider.shifttest.data.repo.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CacheData (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cardNumber: Long? = null,
    val scheme: String? = null,
    val brand: String? = null,
    val isLuhn: Boolean? = null,
    val numLength: Int? = null,
    val type: String? = null,
    val isPrepaid: Boolean? = null,
    val countryName: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val bankName: String? = null,
    val bankUrl: String? = null,
    val bankPhone: String? = null

)