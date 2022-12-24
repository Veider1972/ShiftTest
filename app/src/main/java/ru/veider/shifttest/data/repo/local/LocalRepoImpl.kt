package ru.veider.shifttest.data.repo.local

import android.app.Application
import androidx.room.Room
import ru.veider.shifttest.data.repo.local.data.CacheData
import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource

const val DB_NAME = "History.db"

class LocalRepoImpl(
    app: Application
) : LocalRepo {
    private var db: LocalDataBase

    init {
        db = Room.databaseBuilder(
            app,
            LocalDataBase::class.java,
            DB_NAME
        ).build()
    }

    override suspend fun getCache(): Resource<List<CardData>> =
            try {
                Resource.Success(db.cacheDao().getCache().map {
                    CardData(
                        cardNumber = it.cardNumber,
                        scheme = it.scheme,
                        brand = it.brand,
                        isLuhn = it.isLuhn,
                        numLength = it.numLength,
                        type = it.type,
                        isPrepaid = it.isPrepaid,
                        countryName = it.countryName,
                        latitude = it.latitude,
                        longitude = it.longitude,
                        bankName = it.bankName,
                        bankUrl = it.bankUrl,
                        bankPhone = it.bankPhone
                    )
                })
            } catch (e: Exception) {
                Resource.Error(e)
            }

    override suspend fun putCache(cardData: CardData) {
        db.cacheDao().putCache(CacheData(
            id = 0,
            cardNumber = cardData.cardNumber,
            scheme = cardData.scheme,
            brand = cardData.brand,
            isLuhn = cardData.isLuhn,
            numLength = cardData.numLength,
            type = cardData.type,
            isPrepaid = cardData.isPrepaid,
            countryName = cardData.countryName,
            latitude = cardData.latitude,
            longitude = cardData.longitude,
            bankName = cardData.bankName,
            bankUrl = cardData.bankUrl,
            bankPhone = cardData.bankPhone
        )
        )
    }
}