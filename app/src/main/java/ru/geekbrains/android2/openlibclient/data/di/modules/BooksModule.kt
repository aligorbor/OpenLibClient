package ru.geekbrains.android2.openlibclient.data.di.modules

import dagger.Binds
import dagger.Module
import ru.geekbrains.android2.openlibclient.data.book.OpenLibBookRepository
import ru.geekbrains.android2.openlibclient.data.book.OpenLibBookRepositoryImpl
import ru.geekbrains.android2.openlibclient.data.book.datasource.BookDataSource
import ru.geekbrains.android2.openlibclient.data.book.datasource.CloudBookDataSource
import javax.inject.Singleton

@Module
interface BooksModule {
    @Singleton
    @Binds
    fun bindGitHubUserRepository(repository: OpenLibBookRepositoryImpl): OpenLibBookRepository

    @Singleton
    @Binds
    fun bindUserDataSource(dataSource: CloudBookDataSource): BookDataSource
}