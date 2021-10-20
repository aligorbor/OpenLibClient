package ru.geekbrains.android2.openlibclient.presentation.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.geekbrains.android2.openlibclient.R.layout.view_book
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel

class BooksAdapter(private val delegate: Delegate?) :
    ListAdapter<OpenLibBookViewModel, BookViewHolder>(BookDiff) {

    interface Delegate {
        fun onBookPicked(book: OpenLibBookViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(view_book, parent, false)
        )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}