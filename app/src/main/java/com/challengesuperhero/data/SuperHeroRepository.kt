package com.challengesuperhero.data

import com.challengesuperhero.data.dataSources.SuperHeroDataSource
import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.domain.Result
import com.challengesuperhero.domain.SuperHeroResponse

class SuperHeroRepository constructor(
    private val superHeroDataSource: SuperHeroDataSource
) {

    suspend fun getImageById(id: String): Result<ImageResponse> {
        return superHeroDataSource.getImageById(id)
    }

    suspend fun getInfoById(id: String): Result<SuperHeroResponse> {
        return superHeroDataSource.getInfoById(id)
    }

}