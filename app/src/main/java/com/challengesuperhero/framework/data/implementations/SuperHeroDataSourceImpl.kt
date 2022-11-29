package com.challengesuperhero.framework.data.implementations

import com.challengesuperhero.data.dataSources.SuperHeroDataSource
import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.domain.Result
import com.challengesuperhero.domain.SuperHeroResponse
import com.challengesuperhero.framework.data.config.retrofit.SuperHeroApi
import com.challengesuperhero.framework.presentation.constants.Constants
import javax.inject.Inject

class SuperHeroDataSourceImpl @Inject constructor(
    private val superHeroApi: SuperHeroApi
) : SuperHeroDataSource {

    override suspend fun getImageById(id: String): Result<ImageResponse> = try {
        val response = superHeroApi.getImageById(id)

        if (response.isSuccessful) {
            response.body()?.let { imageInfo ->
                Result.Success(imageInfo)
            } ?: Result.Error(Constants.BODY_NULL_ERROR)
        } else {
            Result.Error(response.message())
        }

    } catch (e: Exception) {
        Result.Error(e.message ?: Constants.GENERIC_ERROR)
    }

    override suspend fun getInfoById(id: String): Result<SuperHeroResponse> = try {
        val response = superHeroApi.getInfoById(id)

        if (response.isSuccessful) {
            response.body()?.let { information ->
                Result.Success(information)
            } ?: Result.Error(Constants.BODY_NULL_ERROR)
        } else {
            Result.Error(response.message())
        }

    } catch (e: Exception) {
        Result.Error(e.message ?: Constants.GENERIC_ERROR)
    }

}