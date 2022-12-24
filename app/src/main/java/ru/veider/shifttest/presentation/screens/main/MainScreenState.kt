package ru.veider.shifttest.presentation.screens.main

import ru.veider.shifttest.data.repo.remote.data.CardData

data class MainScreenState(
    val card: CardData? = null,
    val error: Throwable? = null,
    val cardNumber: String = ""
)