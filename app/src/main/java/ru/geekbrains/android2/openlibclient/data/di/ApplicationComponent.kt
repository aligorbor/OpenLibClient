package ru.geekbrains.android2.openlibclient.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.geekbrains.android2.openlibclient.App
import ru.geekbrains.android2.openlibclient.data.di.modules.ApiModule
import ru.geekbrains.android2.openlibclient.data.di.modules.BooksModule
import ru.geekbrains.android2.openlibclient.data.di.modules.StorageModule
import ru.geekbrains.android2.openlibclient.data.di.modules.UIModule
import ru.geekbrains.android2.openlibclient.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        UIModule::class,
        ApiModule::class,
        BooksModule::class,
        StorageModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent

    }

}