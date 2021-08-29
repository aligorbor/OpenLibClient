package ru.geekbrains.android2.openlibclient.presentation.book

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.openlibclient.R.layout.fragment_book
import ru.geekbrains.android2.openlibclient.arguments
import ru.geekbrains.android2.openlibclient.databinding.FragmentBookBinding
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookDescrViewModel
import ru.geekbrains.android2.openlibclient.presentation.abs.AbsFragment
import javax.inject.Inject

class BookFragment : AbsFragment(fragment_book), BookView {

    companion object Factory {
        private const val ARG_BOOK_KEY = "arg_book_key"
        fun newInstance(key: String): Fragment =
            BookFragment()
                .arguments(ARG_BOOK_KEY to key)
    }

    private val key: String by lazy {
        arguments?.getString(ARG_BOOK_KEY).orEmpty()
    }

    @Inject
    lateinit var presenterFactory: BookPresenterFactory

    @Suppress("unused")
    private val presenter: BookPresenter by moxyPresenter {
        presenterFactory.create(key)
    }

    private val vb: FragmentBookBinding by viewBinding()

    override fun showBookDescr(bookDescr: OpenLibBookDescrViewModel) {
        vb.tvDescription.text = bookDescr.description
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}