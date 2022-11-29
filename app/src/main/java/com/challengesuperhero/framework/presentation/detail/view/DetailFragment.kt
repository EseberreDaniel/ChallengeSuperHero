package com.challengesuperhero.framework.presentation.detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        arguments?.getString(Constants.ID_ARGUMENT)?.let { id ->
            viewModel.getInformationSuperHero(id)
        }
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        viewModel.information.observe(viewLifecycleOwner) { information ->
            information?.let { _info ->
                binding.apply {
                    name.text = _info.name
                    Glide.with(requireContext()).load(_info.image.url).into(image)
                    occupationValue.text = _info.work.occupation
                    baseValue.text = _info.work.base
                    groupValue.text = _info.connections.groupAffiliation
                    appearanceComponent.setAppearance(_info.appearance)
                }
            }
        }
    }
}