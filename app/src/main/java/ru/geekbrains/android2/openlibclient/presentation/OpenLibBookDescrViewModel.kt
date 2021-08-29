package ru.geekbrains.android2.openlibclient.presentation

import ru.geekbrains.android2.openlibclient.data.book.WorkDescr

data class OpenLibBookDescrViewModel(
    val key: String,
    val description: String
) {
    object Mapper {

        fun map(workDescr: WorkDescr) =
            OpenLibBookDescrViewModel(
                workDescr.key,
                workDescr.description?.value ?: "No description"
            )

    }
}
