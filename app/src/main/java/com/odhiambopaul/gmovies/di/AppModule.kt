package com.odhiambopaul.gmovies.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.odhiambopaul.gmovies.common.Constants.BASE_URL
import com.odhiambopaul.gmovies.data.local.AppDatabase
import com.odhiambopaul.gmovies.data.local.MovieDao
import com.odhiambopaul.gmovies.data.remote.GMovieAPI
import com.odhiambopaul.gmovies.data.remote.TokenInterceptor
import com.odhiambopaul.gmovies.data.repository.MovieRepositoryImpl
import com.odhiambopaul.gmovies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder()
            .create()


    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder =
        Retrofit.Builder()
            .client(provideInterceptor())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))


    @Singleton
    @Provides
    fun provideGMovieService(retrofit: Retrofit.Builder): GMovieAPI =
        retrofit
            .build()
            .create(GMovieAPI::class.java)


    @Singleton
    @Provides
    fun provideInterceptor(): OkHttpClient {
        val interceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .addInterceptor(interceptor).build()
    }

    @Singleton
    @Provides
    fun provideGMovieDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "gmovies.db"
    ).build()

    @Singleton
    @Provides
    fun provideGMovieDao(db: AppDatabase) =
        db.movieDao()

    @Provides
    @Singleton
    fun provideMovieRepository(api: GMovieAPI, dao: MovieDao): MovieRepository =
        MovieRepositoryImpl(api, dao)

}