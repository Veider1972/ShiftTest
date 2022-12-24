package ru.veider.shifttest.data.repo.remote.dto

import com.google.gson.annotations.SerializedName

data class CardDto (
    @SerializedName("number")
	val number : NumberDto? = null,
    @SerializedName("scheme")
	val scheme : String? = null,
    @SerializedName("type")
	val type : String? = null,
    @SerializedName("brand")
	val brand : String? = null,
    @SerializedName("prepaid")
	val isPrepaid : Boolean? = null,
    @SerializedName("country")
	val country : CountryDto? = null,
    @SerializedName("bank")
	val bank : BankDto? = null
)