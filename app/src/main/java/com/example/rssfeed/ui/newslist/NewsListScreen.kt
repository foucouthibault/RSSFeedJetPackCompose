package com.example.rssfeed.ui.newslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun NewsListScreen(
    viewModel: NewsListScreenViewModel = hiltViewModel(),
    onNewsClick: (index: Int) -> Unit,
) {
    val articles = viewModel.getTopHeadlines().articles
    if (articles.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(articles) { index, item ->
                Row(
                    modifier = Modifier
                        .clickable {
                            onNewsClick(index)
                        }
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (item.urlToImage != null) {
                        AsyncImage(
                            model = item.urlToImage,
                            contentDescription = null,
                            modifier = Modifier.size(120.dp)
                        )
                        Box(modifier = Modifier.size(30.dp))
                    }
                    Text(item.title, fontWeight = FontWeight.Bold)
                }
                Divider(
                    thickness = 0.5.dp,
                    color = Color.Black
                )
            }
        }
    }
}