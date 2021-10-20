package ru.geekbrains.android2.openlibclient.data.book.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj
import ru.geekbrains.android2.openlibclient.data.di.Persisted
import ru.geekbrains.android2.openlibclient.data.storage.OpenLibStorage
import ru.geekbrains.android2.openlibclient.data.storage.book.SubjWithWorksAndAuthorsStor
import javax.inject.Inject

class CacheBookDataSourceImpl @Inject constructor(
    @Persisted private val openLibStorage: OpenLibStorage
) : CacheBookDataSource {
    override fun retain(worksSubj: WorksSubj): Single<WorksSubj> =
        openLibStorage
            .openLibBookDao()
            .retain(SubjWithWorksAndAuthorsStor.Mapper.mapToStor(worksSubj))
            .andThen(getBooksBySubject(worksSubj.name).toSingle())

    override fun getBooksBySubject(subject: String): Maybe<WorksSubj> =
        openLibStorage
            .openLibBookDao()
            .fetchWorksBySubj(subject)
            .map {
                SubjWithWorksAndAuthorsStor.Mapper.mapFromStor(it)
            }
            .toMaybe()

    override fun getBookDescription(key: String): Maybe<WorkDescr> =
        openLibStorage
            .openLibBookDao()
            .fetchWorkDescrByKey(key)
            .toMaybe()

    override fun retainDescr(workDescr: WorkDescr): Single<WorkDescr> =
        openLibStorage
            .openLibBookDao()
            .insertDescr(workDescr)
            .andThen(getBookDescription(workDescr.keyDescr))
            .toSingle()
}