package com.challengesuperhero.framework.di

import com.challengesuperhero.data.dataSources.SuperHeroDataSource
import com.challengesuperhero.framework.data.config.retrofit.SuperHeroApi
import com.challengesuperhero.framework.data.implementations.SuperHeroDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Inject
    @Provides
    fun provideSuperHeroDataSourceImpl(superHeroApi: SuperHeroApi): SuperHeroDataSource =
        SuperHeroDataSourceImpl(superHeroApi)


}
