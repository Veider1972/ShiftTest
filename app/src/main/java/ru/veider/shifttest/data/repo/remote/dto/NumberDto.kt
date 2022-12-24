package ru.veider.shifttest.data.repo.remote.dto

import com.google.gson.annotations.SerializedName

data class NumberDto (
	@SerializedName("length")
	val numLength : Int? = null,
	@SerializedName("luhn")
	val isLuhn : Boolean? = null
)