package com.datricle.churpy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.datricle.churpy.R
import com.datricle.churpy.composables.MusicViewPager.createItems
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun MusicScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        VerticalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start,
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

                Row{
                    Row(horizontalArrangement = Arrangement.Start){
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
                        Spacer(modifier = Modifier.width(10.dp))
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
                    Row(horizontalArrangement = Arrangement.End) {
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
                    }
                }
            }
        }
    }
}

