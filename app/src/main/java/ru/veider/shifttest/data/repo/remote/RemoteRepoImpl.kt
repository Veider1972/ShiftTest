package ru.veider.shifttest.data.repo.remote

import ru.veider.shifttest.data.repo.remote.dto.CardDto
import ru.veider.shifttest.domain.data.Resource

class RemoteRepoImpl(
    private val webSource: WebSource
) : RemoteRepo {

    override suspend fun getCardInfo(number: Long): Resource<CardDto> =
            webSource.getCardInfo(number)

}