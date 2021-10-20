package ru.geekbrains.android2.openlibclient.presentation.books

import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.presentation.ScreenView

interface BooksView : ScreenView {
    @SingleState
    fun showBooks(books: List<OpenLibBookViewModel>)

}