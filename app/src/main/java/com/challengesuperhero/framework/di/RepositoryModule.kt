package com.challengesuperhero.framework.di

import com.challengesuperhero.data.SuperHeroRepository
import com.challengesuperhero.data.dataSources.SuperHeroDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Inject
    @Provides
    fun provideSuperHeroRepository(
        superHeroDataSource: SuperHeroDataSource
    ): SuperHeroRepository = SuperHeroRepository(superHeroDataSource)

}
