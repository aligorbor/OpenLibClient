package ru.geekbrains.android2.openlibclient.data.book

import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String?
)
