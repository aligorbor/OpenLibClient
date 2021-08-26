package ru.geekbrains.android2.openlibclient.data.book

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String
)
