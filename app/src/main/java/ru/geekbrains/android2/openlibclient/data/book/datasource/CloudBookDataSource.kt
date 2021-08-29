package ru.geekbrains.android2.openlibclient.data.book.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.api.OpenLibApi
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj
import javax.inject.Inject

class CloudBookDataSource @Inject constructor(
    private val openLibApi: OpenLibApi
) : BookDataSource {

    override fun getBooksBySubject(subject: String): Single<WorksSubj> =
       openLibApi.getWorksBySubject(subject)

    override fun getBookDescription(key: String): Single<WorkDescr> =
        openLibApi.getWorkDescription(key)

}