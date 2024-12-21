package com.isayevapps.amphibians.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isayevapps.amphibians.ui.screens.home.components.AmphibianCard
import com.isayevapps.amphibians.models.Amphibian
import com.isayevapps.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(amphibianUiState: AmphibiansUiState, modifier: Modifier = Modifier) {
    when (amphibianUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier)
        is AmphibiansUiState.Success -> AmphibianListScreen(
            amphibianList = amphibianUiState.list,
            modifier = modifier
        )
        is AmphibiansUiState.Error -> ErrorScreen(amphibianUiState.message, modifier = modifier)
    }
}

@Composable
fun AmphibianListScreen(amphibianList: List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(amphibianList) { amphibian ->
            AmphibianCard(amphibian = amphibian)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun ErrorScreen(message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
private fun LoadingScreenPreview() {
    LoadingScreen()
}


@Preview
@Composable
private fun HomeScreenPreview() {
    val amphibian = Amphibian(
        name = "Cool frog",
        type = "frog",
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
        imgSrc = ""
    )
    val amphibianList = listOf(amphibian, amphibian, amphibian)
    AmphibiansTheme {
        //HomeScreen(amphibianList, modifier = Modifier.fillMaxSize())
    }
}