package ru.geekbrains.android2.openlibclient.presentation.books

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class BooksScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        BooksFragment.newInstance()

}