package com.example.virginmoney.di

import com.example.virginmoney.data.api.APIDetail
import com.example.virginmoney.data.api.APIEndpoints
import com.example.virginmoney.data.repository.APIRepository
import com.example.virginmoney.data.repository.APIRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()


    @Provides
    fun provideRetroFitInstance(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(APIDetail.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()


    @Provides
    fun apiInstance(retrofit: Retrofit): APIEndpoints = retrofit.create(APIEndpoints::class.java)

    @Provides
    fun providesRepository(apiEndpoints: APIEndpoints): APIRepository {

        return APIRepositoryImpl(apiEndpoints)

    }
}