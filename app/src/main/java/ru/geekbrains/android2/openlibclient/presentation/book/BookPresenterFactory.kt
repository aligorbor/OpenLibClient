package ru.geekbrains.android2.openlibclient.presentation.book

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel

@AssistedFactory
interface BookPresenterFactory {
    fun create(@Assisted("book") book: OpenLibBookViewModel): BookPresenter
}