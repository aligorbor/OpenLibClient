package ru.geekbrains.android2.openlibclient.data.book

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface OpenLibBookRepository {
    fun getBooksBySubject(subject: String): Observable<WorksSubj>
    fun getBookDescription(key: String): Single<WorkDescr>
}