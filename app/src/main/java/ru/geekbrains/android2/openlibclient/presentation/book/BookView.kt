package ru.geekbrains.android2.openlibclient.presentation.book

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookDescrViewModel
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.presentation.ScreenView

@StateStrategyType(AddToEndSingleStrategy::class)
interface BookView : ScreenView {
    fun showBookDescr(bookDescr: OpenLibBookDescrViewModel, book: OpenLibBookViewModel)
}
