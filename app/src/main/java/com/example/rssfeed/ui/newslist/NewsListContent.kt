package com.example.rssfeed.ui.newslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rssfeed.model.article.Article

@Composable
fun NewsListContent(
    articles: List<Article>,
    onNewsClick: (index: Int) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(articles) { index, item ->
            Card(elevation = 10.dp, modifier = Modifier.padding(10.dp)) {
                Row(
                    modifier = Modifier
                        .clickable {
                            onNewsClick(index)
                        }
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = item.urlToImage?.ifEmpty { "https://example.com/image.jpg" },
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(25.dp))
                    )
                    Box(modifier = Modifier.size(30.dp))
                    Text(
                        item.title,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3
                    )
                }
            }
        }
    }
}