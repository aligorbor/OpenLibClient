package ru.geekbrains.android2.openlibclient.presentation.books.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.geekbrains.android2.openlibclient.click
import ru.geekbrains.android2.openlibclient.databinding.ViewBookBinding
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.setStartDrawableImageFromUri

class BookViewHolder(view: View) : ViewHolder(view) {
    private val viewBinding: ViewBookBinding by viewBinding()

    fun bind(book: OpenLibBookViewModel, delegate: BooksAdapter.Delegate?) {
        with(viewBinding) {
            bookTitle.setStartDrawableImageFromUri(book.coverUri)
            bookTitle.text = book.title

            root.click { delegate?.onBookPicked(book) }
        }
    }
}