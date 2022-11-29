package com.challengesuperhero.framework.presentation.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.challengesuperhero.databinding.FragmentDetailBinding
import com.challengesuperhero.framework.presentation.constants.Constants
import com.challengesuperhero.framework.presentation.detail.viewModel.DetailViewModel
import com.challengesuperhero.framework.presentation.extensionFunctions.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by viewBinding {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.idSuperHero.text = arguments?.getString(Constants.ID_ARGUMENT)
        return binding.root
    }
}