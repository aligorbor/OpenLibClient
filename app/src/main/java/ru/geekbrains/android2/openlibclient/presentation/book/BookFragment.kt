package ru.geekbrains.android2.openlibclient.presentation.book

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.openlibclient.R.layout.fragment_book
import ru.geekbrains.android2.openlibclient.databinding.FragmentBookBinding
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookDescrViewModel
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.presentation.abs.AbsFragment
import ru.geekbrains.android2.openlibclient.setImageFromUri
import javax.inject.Inject

class BookFragment : AbsFragment(fragment_book), BookView {

    companion object Factory {
        private const val ARG_BOOK = "arg_book"
        fun newInstance(book: OpenLibBookViewModel): Fragment =
            BookFragment().apply {
                this.arguments = bundleOf(ARG_BOOK to book)
            }
    }

    private val key: OpenLibBookViewModel by lazy {
        arguments?.getParcelable(ARG_BOOK) ?: OpenLibBookViewModel()
    }

    @Inject
    lateinit var presenterFactory: BookPresenterFactory

    @Suppress("unused")
    private val presenter: BookPresenter by moxyPresenter {
        presenterFactory.create(key)
    }

    private val vb: FragmentBookBinding by viewBinding()

    override fun showBookDescr(bookDescr: OpenLibBookDescrViewModel, book: OpenLibBookViewModel) {
        vb.tvDescription.text = bookDescr.description
        vb.ivCover.setImageFromUri(book.coverUri)
        vb.tvTitle.text = book.title
        vb.tvAuthors.text = book.authors
        vb.tvFirstDate.text = bookDescr.firstPublishDate
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

}