package com.challengesuperhero.framework.presentation.detail.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challengesuperhero.domain.Result
import com.challengesuperhero.domain.SuperHeroResponse
import com.challengesuperhero.usecases.GetInformationSuperHeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getInformationSuperHeroUseCase: GetInformationSuperHeroUseCase
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _information = MutableLiveData<SuperHeroResponse?>()
    val information: LiveData<SuperHeroResponse?> = _information

    fun getInformationSuperHero(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            when (val response = getInformationSuperHeroUseCase.invoke(id)) {
                is Result.Success -> {
                    _information.postValue(response.result)
                }
                else -> {
                }
            }
            _isLoading.postValue(false)
        }
    }
}