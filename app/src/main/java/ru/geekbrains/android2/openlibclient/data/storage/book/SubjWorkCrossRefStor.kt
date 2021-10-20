package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.Entity

@Entity(tableName = "swcrref", primaryKeys = ["keySubj", "keyWork"])
data class SubjWorkCrossRefStor(
    val keySubj: String,
    val keyWork: String
)
