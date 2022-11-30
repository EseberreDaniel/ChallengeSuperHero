package com.challengesuperhero.framework.data.config.retrofit

import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.domain.SuperHeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroApi {

    @GET("{id}/image")
    suspend fun getImageById(@Path("id") id: String): Response<ImageResponse>

    @GET("{id}")
    suspend fun getInfoById(@Path("id") id: String): Response<SuperHeroResponse>

}