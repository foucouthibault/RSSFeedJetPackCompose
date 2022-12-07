package com.example.rssfeed.ui.newslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun NewsListScreen(
    viewModel: NewsListScreenViewModel = hiltViewModel(),
    onNewsClick: (index: Int) -> Unit,
) {
    val article = viewModel.getTopHeadlines().articles
    if (article.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(article) {index, item ->
                Row(
                    Modifier.clickable {
                    onNewsClick(index)
                }){
                    if (item.urlToImage != null) {
                        AsyncImage(
                            model = item.urlToImage,
                            contentDescription = null,
                            modifier = Modifier.size(150.dp))
                    }
                    Text(item.title)
                }
                Divider(
                    thickness = 0.5.dp,
                    color = Color.Black)
            }
        }
    }
}