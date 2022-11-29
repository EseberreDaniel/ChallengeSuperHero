package com.challengesuperhero.framework.presentation.detail.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.challengesuperhero.databinding.ItemAppearanceBinding
import com.challengesuperhero.domain.Appearance
import com.google.android.material.card.MaterialCardView

class AppearanceComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    init {
        radius = 8F
    }

    private var binding: ItemAppearanceBinding =
        ItemAppearanceBinding.inflate(LayoutInflater.from(context), this, true)

    fun setAppearance(appearance: Appearance) {
        binding.apply {
            genderValue.text = appearance.gender
            raceValue.text = appearance.race
            eyeValue.text = appearance.eyeColor
            hairValue.text = appearance.hairColor
            if (appearance.height.isNotEmpty() && appearance.height.size == 2) {
                heightValue.text = appearance.height[1]
            } else {
                height.visibility = View.GONE
                heightValue.visibility = View.GONE
            }
            if (appearance.weight.isNotEmpty() && appearance.weight.size == 2) {
                weightValue.text = appearance.weight[1]
            } else {
                weight.visibility = View.GONE
                weightValue.visibility = View.GONE
            }
        }
    }

}