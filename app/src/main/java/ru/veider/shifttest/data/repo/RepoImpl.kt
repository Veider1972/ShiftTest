package ru.veider.shifttest.data.repo

import kotlinx.coroutines.*
import ru.veider.shifttest.data.repo.local.LocalRepo
import ru.veider.shifttest.data.repo.remote.RemoteRepo
import ru.veider.shifttest.data.repo.remote.data.CardData
import ru.veider.shifttest.domain.data.Resource
import ru.veider.shifttest.domain.repo.Repo

class RepoImpl(
    private val localRepo: LocalRepo,
    private val remoteRepo: RemoteRepo
) : Repo {
    override suspend fun getCardInfo(number: Long): Resource<CardData> =
            when (val dto = remoteRepo.getCardInfo(number)) {
                is Resource.Success -> {
                    Resource.Success(
                        CardData(
                            cardNumber = number,
                            scheme = dto.data.scheme,
                            brand = dto.data.brand,
                            isLuhn = dto.data.number?.isLuhn,
                            numLength = dto.data.number?.numLength,
                            type = dto.data.type,
                            isPrepaid = dto.data.isPrepaid,
                            countryName = dto.data.country?.name,
                            latitude = dto.data.country?.latitude,
                            longitude = dto.data.country?.longitude,
                            bankName = dto.data.bank?.name,
                            bankUrl = dto.data.bank?.url,
                            bankPhone = dto.data.bank?.phone
                        ).apply {
                            CoroutineScope(Dispatchers.IO).launch {
                                localRepo.putCache(this@apply)
                            }
                        }
                    )
                }
                is Resource.Error   -> {
                    Resource.Error(dto.error)
                }
            }

    override suspend fun getCache(): Resource<List<CardData>> = localRepo.getCache()
}