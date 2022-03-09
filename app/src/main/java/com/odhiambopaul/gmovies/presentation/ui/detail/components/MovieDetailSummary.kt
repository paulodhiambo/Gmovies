package com.odhiambopaul.gmovies.presentation.ui.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.presentation.ui.detail.DetailViewModel

@Composable
fun MovieDetailSummary(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val movie: Movie? = viewModel.movieDetailState.value.movie
    Column {
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = "Summary",
            style = MaterialTheme.typography.h6,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie?.overview ?: "",
            style = MaterialTheme.typography.body1,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}
