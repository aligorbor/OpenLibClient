package ru.geekbrains.android2.openlibclient.presentation.books.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel

object BookDiff : DiffUtil.ItemCallback<OpenLibBookViewModel>() {
    private val payload = Any()

    override fun areItemsTheSame(
        oldItem: OpenLibBookViewModel,
        newItem: OpenLibBookViewModel
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: OpenLibBookViewModel,
        newItem: OpenLibBookViewModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: OpenLibBookViewModel, newItem: OpenLibBookViewModel) =
        payload
}