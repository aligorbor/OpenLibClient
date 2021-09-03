package ru.geekbrains.android2.openlibclient.data.book

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class Description(
    @SerializedName("type")
    val type: String,
    @ColumnInfo(name = "description")
    @SerializedName("value")
    val value: String?
)
