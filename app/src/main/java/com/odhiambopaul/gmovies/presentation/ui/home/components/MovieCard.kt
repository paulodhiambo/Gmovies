package com.odhiambopaul.gmovies.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.odhiambopaul.gmovies.R
import com.odhiambopaul.gmovies.common.Constants.SMALL_IMAGE_PATH
import com.odhiambopaul.gmovies.domain.model.Movie
import com.odhiambopaul.gmovies.presentation.theme.shimmerHighLight
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@ExperimentalMaterialApi
@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp)),
        elevation = 10.dp,
        onClick = {
            onMovieClick()
        }
    ) {
        GlideImage(
            imageModel = "${SMALL_IMAGE_PATH}${movie.posterPath}",
            modifier = Modifier
                .width(150.dp)
                .height(250.dp),
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
    }
}