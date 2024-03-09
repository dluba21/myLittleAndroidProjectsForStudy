package com.example.basiccompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtWork(@StringRes val title: Int, @StringRes val artist: Int, @DrawableRes val image: Int)