package ru.geekbrains.android2.openlibclient.data.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.android2.openlibclient.data.di.InMemory
import ru.geekbrains.android2.openlibclient.data.di.Persisted
import ru.geekbrains.android2.openlibclient.data.storage.OpenLibStorage

@Module
class StorageModule {
    @Persisted
    @Provides
    fun provideOpenLibDatabaseStorage(context: Context): OpenLibStorage =
        Room.databaseBuilder(context, OpenLibStorage::class.java, "openlib.db")
            // .addMigrations(OpenLib1to2Migration)
            //        .fallbackToDestructiveMigration()
            .build()

    @InMemory
    @Provides
    fun provideGitHubInMemoryStorage(context: Context): OpenLibStorage =
        Room.inMemoryDatabaseBuilder(context, OpenLibStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}