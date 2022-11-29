package com.challengesuperhero.framework.di

import com.challengesuperhero.framework.data.config.retrofit.SuperHeroApi
import com.challengesuperhero.framework.presentation.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Inject
    @Provides
    fun provideSuperHeroApi(): SuperHeroApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SuperHeroApi::class.java)

}
