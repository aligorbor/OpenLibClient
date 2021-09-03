package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subj")
data class SubjStor(
    @PrimaryKey
    val keySubj: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "workcnt")
    val workCount: String
)
