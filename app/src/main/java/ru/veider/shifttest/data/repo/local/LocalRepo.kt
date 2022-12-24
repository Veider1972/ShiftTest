package ru.veider.shifttest.data.repo.local

import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource

interface LocalRepo {
    suspend fun getCache(): Resource<List<CardData>>
    suspend fun putCache(cardData: CardData)
}