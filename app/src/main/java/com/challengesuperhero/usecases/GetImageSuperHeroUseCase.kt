package com.challengesuperhero.usecases

import com.challengesuperhero.data.SuperHeroRepository
import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.domain.Result
import com.challengesuperhero.framework.presentation.constants.Constants
import javax.inject.Inject

class GetImageSuperHeroUseCase @Inject constructor(
    private val superHeroRepository: SuperHeroRepository
) {

    suspend operator fun invoke(
        positionInitial: Int,
        positionEnd: Int
    ): MutableList<ImageResponse> {
        val listImageResponse = mutableListOf<ImageResponse>()
        for (i in positionInitial..positionEnd) {
            if (i > Constants.POSITION_END) {
                return listImageResponse
            } else {
                when (val response = superHeroRepository.getImageById(i.toString())) {
                    is Result.Success -> {
                        listImageResponse.add(response.result)
                    }
                    else -> {

                    }
                }
            }
        }
        return listImageResponse
    }
}