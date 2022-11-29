package com.challengesuperhero.framework.presentation.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.challengesuperhero.databinding.FragmentListBinding
import com.challengesuperhero.framework.presentation.extensionFunctions.viewBinding
import com.challengesuperhero.framework.presentation.list.viewModel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val binding : FragmentListBinding by viewBinding {
        FragmentListBinding.inflate(layoutInflater)
    }

    private val viewModel : ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}