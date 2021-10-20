package ru.geekbrains.android2.openlibclient.data.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj

interface OpenLibApi {
    @GET("{key}.json")
    fun getWorkDescription(@Path("key") key: String): Single<WorkDescr>

    @GET("/subjects/{subject}.json")
    fun getWorksBySubject(@Path("subject") subject: String): Single<WorksSubj>
}