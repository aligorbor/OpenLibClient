package ru.geekbrains.android2.openlibclient.data.book

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "workdescr")
data class WorkDescr(
    @PrimaryKey
    @SerializedName("key")
    val keyDescr: String,
    @Embedded
    @SerializedName("description")
    val description: Description?,
    @ColumnInfo(name = "firstpubdat")
    @SerializedName("first_publish_date")
    val firstPublishDate: String?
)
