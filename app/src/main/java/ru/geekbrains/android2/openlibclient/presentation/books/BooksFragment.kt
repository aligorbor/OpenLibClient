package ru.geekbrains.android2.openlibclient.presentation.books

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.openlibclient.R.layout.fragment_books
import ru.geekbrains.android2.openlibclient.arguments
import ru.geekbrains.android2.openlibclient.databinding.FragmentBooksBinding
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.presentation.abs.AbsFragment
import ru.geekbrains.android2.openlibclient.presentation.books.adapter.BooksAdapter
import javax.inject.Inject

class BooksFragment : AbsFragment(fragment_books), BooksView, BooksAdapter.Delegate {

    companion object {
        fun newInstance(): Fragment =
            BooksFragment()
                .arguments()
    }

    @Inject
    lateinit var presenterFactory: BooksPresenterFactory

    val presenter: BooksPresenter by moxyPresenter {
        presenterFactory.create()
    }

    private val viewBinding: FragmentBooksBinding by viewBinding()
    private val booksAdapter = BooksAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.books.adapter = booksAdapter
        viewBinding.inputLayoutSubject.setEndIconOnClickListener {
            presenter.getBooksBySubject(viewBinding.subject.text.toString())
        }
    }

    override fun showBooks(books: List<OpenLibBookViewModel>) {
        booksAdapter.submitList(books)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onBookPicked(book: OpenLibBookViewModel) {
        presenter.displayBook(book)
    }
}