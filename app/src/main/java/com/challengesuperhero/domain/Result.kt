package com.challengesuperhero.domain

sealed class Result<T>{
    class Success<T>(val result: T): Result<T>()
    class Error<T>(val error: String): Result<T>()
}
