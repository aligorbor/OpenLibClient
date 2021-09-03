package ru.geekbrains.android2.openlibclient.data.book

import io.reactivex.rxjava3.core.Maybe
import ru.geekbrains.android2.openlibclient.data.book.datasource.BookDataSource
import ru.geekbrains.android2.openlibclient.data.book.datasource.CacheBookDataSource
import javax.inject.Inject

class OpenLibBookRepositoryImpl @Inject constructor(
    private val cloud: BookDataSource,
    private val cache: CacheBookDataSource
) : OpenLibBookRepository {
    override fun getBooksBySubject(subject: String): Maybe<WorksSubj> =
        cache.getBooksBySubject(subject)
            .switchIfEmpty(cloud.getBooksBySubject(subject)
                .flatMap {
                    cache.retain(it).toMaybe()
                })
            .onErrorResumeWith(cloud.getBooksBySubject(subject)
                .flatMap {
                    cache.retain(it).toMaybe()
                })

    override fun getBookDescription(key: String): Maybe<WorkDescr> =
        cache.getBookDescription(key)
            .switchIfEmpty(cloud.getBookDescription(key)
                .flatMap {
                    cache.retainDescr(it).toMaybe()
                })
            .onErrorResumeWith(cloud.getBookDescription(key).flatMap {
                cache.retainDescr(it).toMaybe()
            })

}