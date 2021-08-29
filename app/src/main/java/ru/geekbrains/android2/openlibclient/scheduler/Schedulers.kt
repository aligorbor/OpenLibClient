package ru.geekbrains.android2.openlibclient.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface Schedulers {
    fun background(): Scheduler
    fun main(): Scheduler
}