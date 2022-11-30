package com.challengesuperhero.framework.presentation.detail.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.challengesuperhero.databinding.ItemBiographyBinding
import com.challengesuperhero.domain.Biography
import com.google.android.material.card.MaterialCardView

class BiographyComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {


    private var binding: ItemBiographyBinding =
        ItemBiographyBinding.inflate(LayoutInflater.from(context), this, true)

    fun setBiography(biography: Biography) {
        binding.apply {
            fullNameValue.text = biography.fullName
            aliasesValue.text = biography.aliases.joinToString()
            placeValue.text = biography.placeOfBirth
            firstAppearanceValue.text = biography.firstAppearance
            publisherValue.text = biography.publisher
            alignmentValue.text = biography.alignment
        }
    }

}