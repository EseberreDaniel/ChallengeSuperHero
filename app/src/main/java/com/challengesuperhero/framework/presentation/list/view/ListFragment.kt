package com.challengesuperhero.framework.presentation.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.challengesuperhero.R
import com.challengesuperhero.databinding.FragmentListBinding
import com.challengesuperhero.domain.ImageResponse
import com.challengesuperhero.framework.presentation.constants.Constants
import com.challengesuperhero.framework.presentation.extensionFunctions.viewBinding
import com.challengesuperhero.framework.presentation.list.adapters.ImageListAdapter
import com.challengesuperhero.framework.presentation.list.viewModel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val binding: FragmentListBinding by viewBinding {
        FragmentListBinding.inflate(layoutInflater)
    }

    private val viewModel: ListViewModel by viewModels()

    private lateinit var imageListAdapter: ImageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState:
        Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initObservers()
        viewModel.getImageSuperHero(Constants.POSITION_INITIAL, Constants.RANGE)
    }

    private fun initObservers() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
        viewModel.listImage.observe(viewLifecycleOwner) { list ->
            imageListAdapter.setData(list)
        }
    }

    private fun initComponents() {
        imageListAdapter = ImageListAdapter(object : ImageListAdapter.ImageListener {
            override fun clickImage(image: ImageResponse) {
                findNavController().navigate(
                    R.id.actionlistFragmentToDetailFragment,
                    bundleOf(Constants.ID_ARGUMENT to image.id)
                )
            }

            override fun getMoreSuperHeroes(positionInitial: Int, positionEnd: Int) {
                viewModel.getImageSuperHero(positionInitial, positionEnd)
            }
        })
        binding.recyclerHeroes.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = imageListAdapter
        }
    }
}