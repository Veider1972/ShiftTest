package ru.veider.shifttest.presentation.screens.cache

import ru.veider.shifttest.data.repo.remote.data.CardData

data class CacheScreenState(
    val cacheList: List<CardData>? = null,
    val error: Throwable? = null
)