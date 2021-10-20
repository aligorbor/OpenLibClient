package ru.geekbrains.android2.openlibclient.presentation.book

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel

class BookScreen(private val book: OpenLibBookViewModel) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        BookFragment.newInstance(book)

}