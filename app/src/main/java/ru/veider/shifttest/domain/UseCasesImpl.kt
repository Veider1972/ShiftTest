package ru.veider.shifttest.domain

import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource
import ru.veider.shifttest.domain.repo.Repo

class UseCasesImpl(
    private val repo: Repo
) : UseCases {

    override suspend fun getCardInfo(number: Long): Resource<CardData> =
            when (val card = repo.getCardInfo(number)) {
                is Resource.Success -> {
                    Resource.Success(card.data)
                }
                is Resource.Error   -> {
                    Resource.Error(card.error)
                }
            }

    override suspend fun getCache(): Resource<List<CardData>> = repo.getCache()
}