package ru.veider.shifttest.data.repo.remote.data

import androidx.room.Entity

@Entity
data class CardData (
    val cardNumber: Long? = null,
    val scheme: String? = null,
    val brand: String? = null,
    val numLength: Int? = null,
    val isLuhn: Boolean? = null,
    val type: String? = null,
    val isPrepaid: Boolean? = null,
    val countryName: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val bankName: String? = null,
    val bankUrl: String? = null,
    val bankPhone: String? = null
)