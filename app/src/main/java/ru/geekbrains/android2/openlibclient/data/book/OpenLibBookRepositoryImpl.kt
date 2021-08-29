package ru.geekbrains.android2.openlibclient.data.book

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.book.datasource.BookDataSource
import javax.inject.Inject

class OpenLibBookRepositoryImpl @Inject constructor(
    private val cloud: BookDataSource
) : OpenLibBookRepository {
    override fun getBooksBySubject(subject: String): Observable<WorksSubj> =
        cloud.getBooksBySubject(subject).toObservable()

    override fun getBookDescription(key: String): Single<WorkDescr> =
        cloud.getBookDescription(key)


}