package com.example.composelearning.Data

import com.example.composelearning.R

data class HomeSliderImages(val image: Int, val description: String)

val images = listOf(
    HomeSliderImages(R.drawable.birds, "Birds image"),
    HomeSliderImages(R.drawable.dogs, "Dogs image"),
    HomeSliderImages(R.drawable.cats, "Cats image"),
    )
