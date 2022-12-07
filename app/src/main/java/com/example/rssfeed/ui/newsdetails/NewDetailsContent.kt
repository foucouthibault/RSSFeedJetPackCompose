package com.example.rssfeed.ui.newsdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.rssfeed.model.article.Article

@Composable
fun NewsDetailsContent(article: Article) {
    val uriHandler = LocalUriHandler.current
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (article.urlToImage != null) {
            AsyncImage(model = article.urlToImage, contentDescription = null)
        }
        Text(article.title, fontWeight = FontWeight.Bold)
        if (article.description != null) {
            Text(article.description)
        }
        Text(
            article.url,
            modifier = Modifier.clickable {
                uriHandler.openUri(article.url)
            })
    }
}