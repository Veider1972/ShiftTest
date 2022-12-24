package ru.veider.shifttest.domain

import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource

interface UseCases {
    suspend fun getCardInfo(number:Long): Resource<CardData>
    suspend fun getCache(): Resource<List<CardData>>
}