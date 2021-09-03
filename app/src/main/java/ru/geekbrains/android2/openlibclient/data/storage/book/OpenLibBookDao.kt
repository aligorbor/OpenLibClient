package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr

@Dao
abstract class OpenLibBookDao {
    //   @Inject
    //   lateinit var db: OpenLibStorage

    @Transaction
    @Query("SELECT * FROM subj WHERE name like :subj LIMIT 1")
    abstract fun fetchWorksBySubj(subj: String): Single<SubjWithWorksAndAuthorsStor>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAuthr(author: AuthorStor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWork(work: WorkStor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWorkAuthCrossRef(wa: WorkAuthCrossRefStor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSubjWorkCrossRef(sw: SubjWorkCrossRefStor)

    fun insertWorksWithAuthrs(keySubj: String, worksWithAuthrs: List<WorkWithAuthStor>) {
        worksWithAuthrs.forEach {
            insertWork(it.workStor)
            insertSubjWorkCrossRef(SubjWorkCrossRefStor(keySubj, it.workStor.keyWork))
            it.authorsStor.forEach { authorStor ->
                insertAuthr(authorStor)
                insertWorkAuthCrossRef(
                    WorkAuthCrossRefStor(it.workStor.keyWork, authorStor.keyAuthor)
                )
            }
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSubj(subj: SubjStor)

    fun retain(subjWithWorksAndAuthorsStor: SubjWithWorksAndAuthorsStor) =
        Completable
            .fromAction {
                insertSubj(subjWithWorksAndAuthorsStor.subjStor)
                insertWorksWithAuthrs(
                    subjWithWorksAndAuthorsStor.subjStor.keySubj,
                    subjWithWorksAndAuthorsStor.workWithAuthStor
                )
            }
    //   .subscribeOn(Schedulers.from(db.queryExecutor))

    @Query("SELECT * FROM workdescr WHERE keyDescr like :keyWork LIMIT 1")
    abstract fun fetchWorkDescrByKey(keyWork: String): Single<WorkDescr>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertDescr(descr: WorkDescr): Completable
}