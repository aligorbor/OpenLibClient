package ru.geekbrains.android2.openlibclient.data.book

import io.reactivex.rxjava3.core.Maybe

interface OpenLibBookRepository {
    fun getBooksBySubject(subject: String): Maybe<WorksSubj>
    fun getBookDescription(key: String): Maybe<WorkDescr>
}