package com.odhiambopaul.gmovies.presentation.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun Shimmer() {
    Card(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 10.dp,
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .width(150.dp)
                .shimmer()
                .background(Color.Gray),
        )
    }

}