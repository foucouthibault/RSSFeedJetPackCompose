package com.example.rssfeed.ui.newslist

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NewsListScreen(
    viewModel: NewsListScreenViewModel = hiltViewModel(),
    onNewsClick: (index: Int) -> Unit,
) {
    val articles = viewModel.getTopHeadlines().articles
    if (articles.isNotEmpty()) {
        Scaffold(
            content = {
                NewsListContent(articles = articles, onNewsClick = onNewsClick)
            }
        )
    }
}