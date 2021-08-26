package ru.geekbrains.android2.openlibclient.presentation

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ScreenView : MvpView {

    @SingleState
    fun showError(error: Throwable)

}