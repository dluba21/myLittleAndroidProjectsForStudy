package com.example.basiccompose.model

import com.example.basiccompose.R

class DataSource {
    fun getArtWorkList(): List<ArtWork> {
        return listOf(
            ArtWork(R.string.malevich, R.string.coloredSquares, R.drawable.malevich1),
            ArtWork(R.string.malevich, R.string.autoportret, R.drawable.screenshot_2024_03_05_at_22_05_07),
            ArtWork(R.string.malevich, R.string.men, R.drawable.screenshot_2024_03_05_at_22_04_56),
        )
    }
}