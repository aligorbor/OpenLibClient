package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.geekbrains.android2.openlibclient.data.book.WorksSubj

data class SubjWithWorksAndAuthorsStor(
    @Embedded val subjStor: SubjStor,
    @Relation(
        entity = WorkStor::class,
        parentColumn = "keySubj",
        entityColumn = "keyWork",
        //     entityColumn = "subjKey",
        associateBy = Junction(SubjWorkCrossRefStor::class)
    )
    val workWithAuthStor: List<WorkWithAuthStor>
) {
    object Mapper {
        fun mapFromStor(subjWorksStor: SubjWithWorksAndAuthorsStor): WorksSubj =
            WorksSubj(
                key = subjWorksStor.subjStor.keySubj,
                name = subjWorksStor.subjStor.name,
                workCount = subjWorksStor.subjStor.workCount,
                works = subjWorksStor.workWithAuthStor.map {
                    WorkWithAuthStor.Mapper.mapFromStor(it)
                }
            )

        fun mapToStor(worksSubj: WorksSubj): SubjWithWorksAndAuthorsStor =
            SubjWithWorksAndAuthorsStor(
                subjStor = SubjStor(worksSubj.key, worksSubj.name, worksSubj.workCount),
                workWithAuthStor = worksSubj.works.map {
                    WorkWithAuthStor.Mapper.mapToStor(it)
                }
            )
    }
}


