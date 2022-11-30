package com.challengesuperhero.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
): Parcelable