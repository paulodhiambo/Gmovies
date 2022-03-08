package com.odhiambopaul.gmovies.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.odhiambopaul.gmovies.presentation.ui.home.components.PopularSection
import com.odhiambopaul.gmovies.presentation.ui.home.components.TopRatedSection
import com.odhiambopaul.gmovies.presentation.ui.home.components.UpComingSection

@Composable
@ExperimentalMaterialApi
fun HomeScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Top Rated Movies",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            )
            TopRatedSection(navController = navController)
            Text(
                text = "Upcoming Movies",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            )
            UpComingSection(navController = navController)
            Text(
                text = "Popular Movies",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            )
            PopularSection(navController = navController)
        }
    }
}