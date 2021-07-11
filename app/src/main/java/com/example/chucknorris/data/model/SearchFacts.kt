package com.example.chucknorris.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchFacts(

	@field:SerializedName("result")
	val result: List<ResultItem?>? = null,

	@field:SerializedName("total")
	val total: Int? = null
) : Parcelable

@Parcelize
data class ResultItem(

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("categories")
	val categories: List<String?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable
