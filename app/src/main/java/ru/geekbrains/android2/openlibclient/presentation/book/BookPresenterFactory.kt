package ru.geekbrains.android2.openlibclient.presentation.book

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface BookPresenterFactory {
    fun create(@Assisted("key") key: String): BookPresenter
}