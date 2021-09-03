package ru.geekbrains.android2.openlibclient.data.book.datasource

import io.reactivex.rxjava3.core.Maybe
import ru.geekbrains.android2.openlibclient.data.api.OpenLibApi
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj
import javax.inject.Inject

class CloudBookDataSource @Inject constructor(
    private val openLibApi: OpenLibApi
) : BookDataSource {

    override fun getBooksBySubject(subject: String): Maybe<WorksSubj> =
        openLibApi.getWorksBySubject(subject)
            .map {
                it.works.forEach { work ->
                    work.subjKey = it.key
                }
                it
            }.toMaybe()

    override fun getBookDescription(key: String): Maybe<WorkDescr> =
        openLibApi.getWorkDescription(key)
            .toMaybe()

}