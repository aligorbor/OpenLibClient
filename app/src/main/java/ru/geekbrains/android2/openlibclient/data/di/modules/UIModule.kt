package ru.geekbrains.android2.openlibclient.data.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.android2.openlibclient.presentation.MainActivity

@Module
interface UIModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}