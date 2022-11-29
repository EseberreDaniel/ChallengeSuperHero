package com.challengesuperhero.framework.presentation.list.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.usecases.GetImageSuperHeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getImageSuperHeroUseCase: GetImageSuperHeroUseCase
) : ViewModel() {

    private val _listImage: MutableLiveData<MutableList<ImageResponse>> =
        MutableLiveData(arrayListOf())
    val listImage: LiveData<MutableList<ImageResponse>> get() = _listImage

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun getImageSuperHero(positionInitial: Int, positionEnd: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            val response = getImageSuperHeroUseCase.invoke(positionInitial, positionEnd)
            _listImage.value?.addAll(response)
            _isLoading.postValue(false)
        }
    }
}