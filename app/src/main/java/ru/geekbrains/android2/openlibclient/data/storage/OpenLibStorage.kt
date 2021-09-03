package ru.geekbrains.android2.openlibclient.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.storage.book.*

@Database(
    exportSchema = false,
    entities = [
        AuthorStor::class,
        SubjStor::class,
        SubjWorkCrossRefStor::class,
        WorkAuthCrossRefStor::class,
        WorkStor::class,
        WorkDescr::class
    ],
    version = 1
)
abstract class OpenLibStorage : RoomDatabase() {
    abstract fun openLibBookDao(): OpenLibBookDao
}