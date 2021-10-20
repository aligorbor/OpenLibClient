package ru.geekbrains.android2.openlibclient

import org.junit.Assert
import org.junit.Test
import ru.geekbrains.android2.openlibclient.data.book.Author
import ru.geekbrains.android2.openlibclient.data.book.Description
import ru.geekbrains.android2.openlibclient.data.book.Work
import ru.geekbrains.android2.openlibclient.data.book.WorkDescr
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookDescrViewModel
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel

class ViewModelMapTest {
    @Test
    fun bookDescrViewModelMap_EqualDescription_ReturnsTrue() {
        val description = "Description of the book"
        Assert.assertEquals(
            description,
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", description), "01.01.2000")
            ).description
        )
    }

    @Test
    fun bookDescrViewModelMap_NotEqualDescription_ReturnsTrue() {
        Assert.assertNotEquals(
            null,
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", null), "01.01.2000")
            ).description
        )
    }

    @Test
    fun bookDescrViewModelMap_NotNullDescription_ReturnsTrue() {
        Assert.assertNotNull(
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", null), "01.01.2000")
            ).description
        )
    }

    @Test
    fun bookDescrViewModelMap_NotNullFirstPublishDate_ReturnsTrue() {
        Assert.assertNotNull(
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", null), null)
            ).firstPublishDate
        )
    }

    @Test
    fun bookDescrViewModelMap_NotEqualFirstPublishDate_ReturnsTrue() {
        Assert.assertNotEquals(
            null,
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", null), null)
            ).firstPublishDate
        )
    }

    @Test
    fun bookDescrViewModelMap_SameDescription_ReturnsTrue() {
        val description = "Description of the book"
        Assert.assertSame(
            description,
            OpenLibBookDescrViewModel.Mapper.map(
                WorkDescr("key", Description("subject", description), "01.01.2000")
            ).description
        )
    }

    @Test
    fun bookViewModelMap_EqualTitle_ReturnsTrue() {
        val coverId = 1234567
        val title = "Title of the book"
        Assert.assertEquals(
            title,
            OpenLibBookViewModel.Mapper.map(
                Work(
                    "key",
                    title,
                    coverId,
                    arrayListOf(
                        Author("key1", "author1"),
                        Author("key1", "author2"),
                        Author("key1", "author3")
                    ),
                    "subjKey"
                )
            ).title
        )
    }

    @Test
    fun bookViewModelMap_EqualCoverUri_ReturnsTrue() {
        val coverId = 1234567
        Assert.assertEquals(
            "http://covers.openlibrary.org/b/ID/$coverId-M.jpg",
            OpenLibBookViewModel.Mapper.map(
                Work(
                    "key",
                    "title",
                    coverId,
                    arrayListOf(
                        Author("key1", "author1"),
                        Author("key1", "author2"),
                        Author("key1", "author3")
                    ),
                    "subjKey"
                )
            ).coverUri
        )
    }

    @Test
    fun bookViewModelMap_NotSameCoverUri_ReturnsTrue() {
        val coverId = 1234567
        Assert.assertNotSame(
            "http://covers.openlibrary.org/b/ID/$coverId-M.jpg",
            OpenLibBookViewModel.Mapper.map(
                Work(
                    "key",
                    "title",
                    coverId,
                    arrayListOf(
                        Author("key1", "author1"),
                        Author("key1", "author2"),
                        Author("key1", "author3")
                    ),
                    "subjKey"
                )
            ).coverUri
        )
    }

    @Test
    fun bookViewModelMap_ArrayEqualCoverUri_ReturnsTrue() {
        val coverId = 1234567
        val authors = arrayOf("author1", "author2", "author3")
        Assert.assertArrayEquals(
            authors,
            OpenLibBookViewModel.Mapper.map(
                Work(
                    "key",
                    "title",
                    coverId,
                    arrayListOf(
                        Author("key1", authors[0]),
                        Author("key1", authors[1]),
                        Author("key1", authors[2])
                    ),
                    "subjKey"
                )
            ).authors.split(",").map {
                it.trim()
            }.toTypedArray()
        )
    }
}