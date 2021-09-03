package ru.geekbrains.android2.openlibclient.presentation

import ru.geekbrains.android2.openlibclient.data.book.WorkDescr

data class OpenLibBookDescrViewModel(
    val key: String,
    val description: String,
    val firstPublishDate: String
) {
    object Mapper {

        fun map(workDescr: WorkDescr) =
            OpenLibBookDescrViewModel(
                workDescr.keyDescr,
                workDescr.description?.value ?: "No description",
                workDescr.firstPublishDate ?: ""
            )

    }
}
