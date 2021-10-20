package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.geekbrains.android2.openlibclient.data.book.Work

data class WorkWithAuthStor(
    @Embedded val workStor: WorkStor,
    @Relation(
        parentColumn = "keyWork",
        entityColumn = "keyAuthor",
        associateBy = Junction(WorkAuthCrossRefStor::class)
    )
    val authorsStor: List<AuthorStor>
) {
    object Mapper {
        fun mapFromStor(workStor: WorkWithAuthStor): Work =
            Work(
                key = workStor.workStor.keyWork,
                title = workStor.workStor.title,
                coverId = workStor.workStor.coverId,
                authors = workStor.authorsStor.map {
                    AuthorStor.Mapper.mapFromStor(it)
                },
                subjKey = workStor.workStor.subjKey
            )

        fun mapToStor(work: Work): WorkWithAuthStor =
            WorkWithAuthStor(
                workStor = WorkStor(work.key, work.subjKey, work.title, work.coverId),
                authorsStor = work.authors.map {
                    AuthorStor.Mapper.mapToStor(it)
                })
    }

}


