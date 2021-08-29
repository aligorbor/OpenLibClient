package ru.geekbrains.android2.openlibclient.presentation.book

import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.geekbrains.android2.openlibclient.data.book.OpenLibBookRepository
import ru.geekbrains.android2.openlibclient.presentation.OpenLibBookDescrViewModel
import ru.geekbrains.android2.openlibclient.scheduler.Schedulers

class BookPresenter @AssistedInject constructor(
    @Assisted("key") private val key: String,
    private val bookRepository: OpenLibBookRepository,
    private val router: Router,
    private val schedulers: Schedulers

) : MvpPresenter<BookView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables +=
            bookRepository
                .getBookDescription(key)
                .map(OpenLibBookDescrViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showBookDescr,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }
}