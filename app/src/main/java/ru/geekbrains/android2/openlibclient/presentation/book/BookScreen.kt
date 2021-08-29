package ru.geekbrains.android2.openlibclient.presentation.book

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class BookScreen(private val key: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        BookFragment.newInstance(key)

}