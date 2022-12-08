package com.example.rssfeed.ui.newsdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rssfeed.model.article.Article

@Composable
fun NewsDetailsContent(article: Article) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (article.urlToImage != null) {
            AsyncImage(model = article.urlToImage, contentDescription = null)
            Box(modifier = Modifier.size(10.dp))
        }
        Column(Modifier.padding(horizontal = 10.dp)) {
            Text(
                article.title,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            if (article.description != null) {
                Box(modifier = Modifier.size(10.dp))
                Text(
                    article.description,
                    fontSize = 16.sp
                )
                Box(modifier = Modifier.size(10.dp))
            }
            Text(
                article.url,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.clickable {
                    uriHandler.openUri(article.url)
                })
        }
    }
}