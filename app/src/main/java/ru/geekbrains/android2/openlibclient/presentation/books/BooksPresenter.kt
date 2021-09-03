package ru.geekbrains.android2.openlibclient.presentation.books

import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.geekbrains.android2.openlibclient.data.book.OpenLibBookRepository
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookViewModel.Mapper
import ru.geekbrains.android2.openlibclient.presentation.book.BookScreen
import ru.geekbrains.android2.openlibclient.scheduler.Schedulers

class BooksPresenter @AssistedInject constructor(
    private val bookRepository: OpenLibBookRepository,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<BooksView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        getBooksBySubject("cat")
    }

    fun displayBook(book: OpenLibBookViewModel) {
        router.navigateTo(BookScreen(book))
    }

    fun getBooksBySubject(subjName: String) {
        disposables +=
            bookRepository
                .getBooksBySubject(subjName)
                .observeOn(schedulers.background())
                .map { worksSubj -> worksSubj.works.map(Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showBooks,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.dispose()
    }


}