package ru.geekbrains.android2.openlibclient.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.geekbrains.android2.openlibclient.data.book.Work

@Parcelize
data class OpenLibBookViewModel(
    val key: String = "",
    val title: String = "",
    val authors: String = "",
    val coverUri: String = ""
) : Parcelable {
    object Mapper {

        fun map(work: Work) =
            OpenLibBookViewModel(
                work.key,
                work.title,
                (work.authors.map {
                    it.name
                }).joinToString {
                    it
                },
                "http://covers.openlibrary.org/b/ID/${work.coverId}-M.jpg"
            )
    }

}
