package com.example.chucknorris.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JokesRandom(
    @SerializedName("categories")
    val categories: List<Category> = listOf(),
    @SerializedName("icon_url")
    val iconUrl: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("value")
    val value: String = ""
) : Parcelable
