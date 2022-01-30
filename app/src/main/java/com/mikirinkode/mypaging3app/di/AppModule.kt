package com.mikirinkode.mypaging3app.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.mikirinkode.mypaging3app.data.source.Repository
import com.mikirinkode.mypaging3app.data.source.local.MovieDao
import com.mikirinkode.mypaging3app.data.source.local.MovieDatabase
import com.mikirinkode.mypaging3app.data.source.remote.MovieApi
import com.mikirinkode.mypaging3app.utils.Constants.Companion.BASE_URL
import com.mikirinkode.mypaging3app.utils.Constants.Companion.MOVIE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieAPi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            MOVIE_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideRepository(movieApi: MovieApi, movieDatabase: MovieDatabase): Repository{
        return Repository(movieApi, movieDatabase)
    }
}