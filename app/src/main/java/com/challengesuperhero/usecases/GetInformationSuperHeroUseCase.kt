package com.challengesuperhero.usecases

import com.challengesuperhero.data.SuperHeroRepository
import com.challengesuperhero.domain.Result
import com.challengesuperhero.domain.SuperHeroResponse
import javax.inject.Inject

class GetInformationSuperHeroUseCase @Inject constructor(
    private val superHeroRepository: SuperHeroRepository
) {
    suspend operator fun invoke(id: String): Result<SuperHeroResponse> {
        return superHeroRepository.getInfoById(id)
    }
}