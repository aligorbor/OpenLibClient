package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.Entity

@Entity(tableName = "wacrref", primaryKeys = ["keyWork", "keyAuthor"])
data class WorkAuthCrossRefStor(
    val keyWork: String,
    val keyAuthor: String
)
