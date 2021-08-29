package ru.geekbrains.android2.openlibclient.data.book.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj

interface BookDataSource {
    fun getBooksBySubject(subject: String): Single<WorksSubj>
    fun getBookDescription( key: String): Single<WorkDescr>
}