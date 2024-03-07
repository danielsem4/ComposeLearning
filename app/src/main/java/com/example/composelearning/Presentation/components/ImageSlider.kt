@file:OptIn(ExperimentalPagerApi::class)

package com.example.composelearning.Presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composelearning.Data.Dimen.MediumCardElevation
import com.example.composelearning.Data.Dimen.MediumPadding1
import com.example.composelearning.Data.Dimen.selectedDot
import com.example.composelearning.Data.Dimen.unselectedDot
import com.example.composelearning.Data.HomeSliderImages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@Composable
fun ImageSlider(
    modifier: Modifier = Modifier,
    images: List<HomeSliderImages>,
) {
    val pagerState = rememberPagerState(pageCount = images.size)

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(modifier = modifier.wrapContentSize()) {
        HorizontalPager(
            state = pagerState,
            modifier
                .wrapContentSize()
        ) {
            Card(
                modifier
                    .wrapContentSize()
                    .padding(MediumPadding1),
                elevation = CardDefaults.cardElevation(MediumCardElevation)
            ) {
                Image(
                    painter = painterResource(id = images[it].image),
                    contentDescription = images[it].description
                )
            }
        }
    }
    PageIndicator(
        modifier = modifier,
        pageCount = images.size,
        currentPage = pagerState.currentPage
    )
}

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageCount: Int,
    currentPage: Int,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorDots(isSelected: Boolean) {

    val size =
        animateDpAsState(targetValue = if (isSelected) selectedDot else unselectedDot, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color.Red else Color.Gray)
    )
}



