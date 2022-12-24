package ru.veider.shifttest.data.repo.remote

import ru.veider.shifttest.data.repo.remote.dto.CardDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WebApi {
    @GET("/{cardNum}")
    suspend fun getCardData(
        @Path("cardNum") cardNum: Long): CardDto
}