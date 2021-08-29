package ru.geekbrains.android2.openlibclient.presentation.books

import dagger.assisted.AssistedFactory

@AssistedFactory
interface BooksPresenterFactory {
    fun create(): BooksPresenter
}