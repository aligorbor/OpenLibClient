package ru.geekbrains.android2.openlibclient.presentation

import ru.geekbrains.android2.openlibclient.data.book.Work

data class OpenLibBookViewModel(
    val key: String,
    val title: String,
    val authors: String,
    val coverUri: String
) {
    object Mapper {

        fun map(work: Work) =
            OpenLibBookViewModel(
                work.key,
                work.title,
                work.authors[0].name,
                "http://covers.openlibrary.org/b/ID/${work.coverId}-M.jpg"
            )

    }

}
