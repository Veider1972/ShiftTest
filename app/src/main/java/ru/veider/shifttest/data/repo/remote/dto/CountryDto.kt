package ru.veider.shifttest.data.repo.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryDto (
	@SerializedName("numeric")
	val numeric : Int? = null,
	@SerializedName("alpha2")
	val alpha2 : String? = null,
	@SerializedName("name")
	val name : String? = null,
	@SerializedName("emoji")
	val emoji : String? = null,
	@SerializedName("currency")
	val currency : String? = null,
	@SerializedName("latitude")
	val latitude : Double? = null,
	@SerializedName("longitude")
	val longitude : Double? = null
)