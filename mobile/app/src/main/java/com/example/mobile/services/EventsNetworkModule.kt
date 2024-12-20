package com.example.mobile.services

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EventsNetworkModule {

    @Provides
    @Singleton
    @Named("EventsRetrofit")
    fun provideEventsRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://stoplight.io/mocks/ig2i/2i-vents/665341912/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideEventsApiService(@Named("EventsRetrofit") retrofit: Retrofit): EventsApiService {
        return retrofit.create(EventsApiService::class.java)
    }
}

