package ru.geekbrains.android2.openlibclient.data.book

import com.google.gson.annotations.SerializedName

data class WorkDescr(
    @SerializedName("description")
    val description: Description,
    @SerializedName("key")
    val key: String
)
