package ru.veider.shifttest.data.repo.remote

import ru.veider.shifttest.data.repo.remote.dto.CardDto
import ru.veider.shifttest.domain.data.Resource

interface RemoteRepo {
    suspend fun getCardInfo(number: Long): Resource<CardDto>
}