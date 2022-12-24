package ru.veider.shifttest.domain.repo

import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource

interface Repo {
    suspend fun getCardInfo(number:Long): Resource<CardData>
    suspend fun getCache():Resource<List<CardData>>
}