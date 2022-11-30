package com.challengesuperhero.framework.presentation.detail.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.challengesuperhero.databinding.StatsDialogBinding
import com.challengesuperhero.domain.Powerstats
import com.challengesuperhero.framework.presentation.constants.Constants
import com.challengesuperhero.framework.presentation.extensionFunctions.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StatsDialogComponent : BottomSheetDialogFragment() {

    private val binding: StatsDialogBinding by viewBinding(StatsDialogBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stats = arguments?.getParcelable<Powerstats>(Constants.STATS_ARGUMENT)
        stats?.let { _stats ->
            binding.apply {
                intelligenceValue.text = _stats.intelligence
                strengthValue.text = _stats.strength
                speedValue.text = _stats.speed
                durabilityValue.text = _stats.durability
                powerValue.text = _stats.power
                combatValue.text = _stats.combat
            }
        }
    }
}