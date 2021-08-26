package ru.geekbrains.android2.openlibclient.data.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.android2.openlibclient.data.api.OpenLibApi
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("openlib_api")
    @Provides
    fun provideBaseUrlProd(): String = "http://openlibrary.org"

    @Singleton
    @Provides
    fun provideGitHubApi(@Named("openlib_api") baseUrl: String): OpenLibApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(OpenLibApi::class.java)

    private val gson: Gson =
        GsonBuilder()
            .create()

}