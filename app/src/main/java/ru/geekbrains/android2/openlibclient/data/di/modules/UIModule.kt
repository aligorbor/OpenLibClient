package ru.geekbrains.android2.openlibclient.data.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.android2.openlibclient.presentation.MainActivity
import ru.geekbrains.android2.openlibclient.presentation.book.BookFragment
import ru.geekbrains.android2.openlibclient.presentation.books.BooksFragment

@Module
interface UIModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindBooksFragment(): BooksFragment

    @ContributesAndroidInjector
    fun bindBookFragment(): BookFragment

}