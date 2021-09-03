package ru.geekbrains.android2.openlibclient.data.storage.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.geekbrains.android2.openlibclient.data.book.Author

@Entity(tableName = "author")
data class AuthorStor(
    @PrimaryKey
    val keyAuthor: String,
    @ColumnInfo(name = "name")
    val name: String
) {

    object Mapper {
        fun mapFromStor(authorStor: AuthorStor): Author =
            Author(
                key = authorStor.keyAuthor,
                name = authorStor.name
            )

        fun mapToStor(author: Author): AuthorStor =
            AuthorStor(
                keyAuthor = author.key,
                name = author.name
            )

    }
}