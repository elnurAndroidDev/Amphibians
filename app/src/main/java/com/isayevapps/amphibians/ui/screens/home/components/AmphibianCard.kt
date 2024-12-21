package com.isayevapps.amphibians.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.isayevapps.amphibians.R
import com.isayevapps.amphibians.models.Amphibian
import com.isayevapps.amphibians.ui.theme.AmphibiansTheme
import com.isayevapps.amphibians.ui.theme.Primary

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Primary)) {
            Text(
                text = amphibian.name,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(amphibian.imgSrc)
                    .crossfade(true).build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentScale = ContentScale.Crop,
                contentDescription = "frog",
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = amphibian.description, textAlign = TextAlign.Justify, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun AmphibianCardPreview() {
    val amphibian = Amphibian(
        name = "Amphibian Name",
        type = "Amphibian Type",
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
        imgSrc = "")
    AmphibiansTheme {
        AmphibianCard(
            amphibian = amphibian,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}