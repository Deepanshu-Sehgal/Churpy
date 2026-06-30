package com.datricle.churpy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Button
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.datricle.churpy.R
import com.datricle.churpy.composables.MusicViewPager.createItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview(showSystemUi = true)
fun MusicScreen() {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        // Simple network search UI: enter a query and tap Search to fetch raw results.
        var query by remember { mutableStateOf("diljit dosanj") }
        var searchResult by remember { mutableStateOf<String?>(null) }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                scope.launch {
                    searchResult = try {
                        com.datricle.churpy.api.Spotify.search(query)
                    } catch (e: Exception) {
                        "Error: ${e.localizedMessage}"
                    }
                }
            }) {
                Text("Search")
            }
        }

        // Show a short preview of the raw search result (for debugging/demo).
        searchResult?.let { res ->
            Text(
                text = if (res.length > 400) res.substring(0, 400) + "..." else res,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            )
        }
        val items = createItems()
        val pagerState = rememberPagerState()

        VerticalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Image(
                painter = painterResource(id = R.drawable.bg),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillHeight,
                contentDescription = "Song Image"
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = items[currentPage].song_name,
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].singer_name,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Column {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_favorite),
                                    contentDescription = "Favorite"
                                )
                                Text(
                                    fontSize = 12.sp,
                                    text = "111.6k"
                                )
                            }

                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Column {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = "Share"
                                )
                                Text(
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp, text = "Share"
                                )
                            }
                        }
                    }
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_more),
                                contentDescription = "More"
                            )

                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    var sliderPosition by remember { mutableStateOf(0f) }
                    //Text(text = sliderPosition.toString())
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it },
                        valueRange = 0f..100f,
                        onValueChangeFinished = {
                            // launch some business logic update with the state you hold
                            // viewModel.updateSelectedSliderValue(sliderPosition)
                        },
                        colors = SliderDefaults.colors(
                            thumbColor = Color.White,
                            activeTrackColor = Color.White
                        )
                    )
                    // Text(text = sliderPosition.toString())
                }
            }
        }
    }
}

