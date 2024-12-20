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
object UserNetworkModule {

    @Provides
    @Singleton
    @Named("UserRetrofit")
    fun provideUserRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://virtserver.swaggerhub.com/MOLANTOINEPROMAIL/user-api/1.0.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApiService(@Named("UserRetrofit") retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }
}

