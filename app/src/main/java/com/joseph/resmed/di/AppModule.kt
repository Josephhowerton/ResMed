package com.joseph.resmed.di

import com.joseph.resmed.BuildConfig
import com.joseph.resmed.network.service.SportsService
import com.joseph.resmed.source.Repository
import com.joseph.resmed.source.SportsSource
import com.joseph.resmed.source.impl.RepositoryImpl
import com.joseph.resmed.source.impl.SportsSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
        } else {
            OkHttpClient.Builder().build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SportsService.BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideSportsService(retrofit: Retrofit): SportsService = retrofit.create(SportsService::class.java)

    @Provides
    @Singleton
    fun provideSportsSource(sportsSource: SportsSourceImpl) : SportsSource = sportsSource

    @Provides
    @Singleton
    fun provideRepository(repository: RepositoryImpl) : Repository = repository
}