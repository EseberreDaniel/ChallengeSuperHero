package com.challengesuperhero.data.dataSources

import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.domain.SuperHeroResponse
import com.challengesuperhero.domain.Result

interface SuperHeroDataSource {

    suspend fun getImageById(id: String): Result<ImageResponse>

    suspend fun getInfoById(id: String): Result<SuperHeroResponse>

}