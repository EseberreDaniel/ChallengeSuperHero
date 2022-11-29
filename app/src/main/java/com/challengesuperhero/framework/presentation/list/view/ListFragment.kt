package com.challengesuperhero.framework.presentation.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challengesuperhero.databinding.FragmentListBinding
import com.challengesuperhero.framework.presentation.extensionFunctions.viewBinding


class ListFragment : Fragment() {

    private val binding : FragmentListBinding by viewBinding {
        FragmentListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}