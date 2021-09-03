package ru.geekbrains.android2.openlibclient.data.book.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj

interface CacheBookDataSource : BookDataSource {
    fun retain(worksSubj: WorksSubj): Single<WorksSubj>
    fun retainDescr(workDescr: WorkDescr): Single<WorkDescr>

}