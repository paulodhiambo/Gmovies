package com.odhiambopaul.gmovies.presentation.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odhiambopaul.gmovies.common.Constants
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.presentation.theme.shimmerHighLight
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieDetailScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.movieDetailState.value
    if (state.movie != null) {
        Column() {
            MovieDetailHeader()
            MovieDetailSummary()
        }
    }
}

@Composable
private fun MovieDetailHeader(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val movie: Movie? = viewModel.movieDetailState.value.movie
    val movieTrailer = viewModel.movieTrailerDataState.value.trailer
    Column {
        GlideImage(
            imageModel = "${Constants.LARGE_IMAGE_PATH}${movie?.posterPath}",
            modifier = Modifier
                .height(320.dp),
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = shimmerHighLight,
                durationMillis = 350,
                dropOff = 0.65f,
                tilt = 20f
            ),
            failure = {
                Text(text = "image request failed.")
            })

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = movie?.title ?: "",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Release Date: ${movie?.releaseDate}",
            style = MaterialTheme.typography.body1,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
private fun MovieDetailSummary(
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
