package com.odhiambopaul.gmovies.presentation.ui.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.odhiambopaul.gmovies.R
import com.odhiambopaul.gmovies.common.Constants
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.presentation.theme.shimmerHighLight
import com.odhiambopaul.gmovies.presentation.ui.detail.DetailViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieDetailHeader(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val movie: Movie? = viewModel.movieDetailState.value.movie
    if (viewModel.movieDetailState.value.isLoading && movie == null) {
        DetailShimmer()
    }
    Column {
        GlideImage(
            imageModel = "${Constants.LARGE_IMAGE_PATH}${movie?.backdropPath}",
            modifier = Modifier
                .height(400.dp),
            shimmerParams = ShimmerParams(
                baseColor = MaterialTheme.colors.background,
                highlightColor = shimmerHighLight,
                durationMillis = 350,
                dropOff = 0.65f,
                tilt = 20f
            ),
            failure = {
                Image(
                    painter = painterResource(id = R.drawable.gmovie),
                    contentDescription = "default image",
                    modifier = Modifier.fillMaxSize()
                )
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
