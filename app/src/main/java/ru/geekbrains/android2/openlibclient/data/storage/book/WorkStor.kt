package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "work")
data class WorkStor(
    @PrimaryKey
    val keyWork: String,
    val subjKey: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = " coverid")
    val coverId: Int
)
