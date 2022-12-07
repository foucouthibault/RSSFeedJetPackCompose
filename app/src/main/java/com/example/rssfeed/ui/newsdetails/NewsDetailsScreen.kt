package com.example.rssfeed.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.rssfeed.ui.newsdetails.NewsDetailsContent
import com.example.rssfeed.ui.newsdetails.NewsDetailsTopBar
import com.example.rssfeed.ui.newslist.NewsListScreenViewModel

@Composable
fun NewsDetailsScreen(
    index: Int?,
    viewModel: NewsListScreenViewModel = NewsListScreenViewModel(),
    onBack: () -> Unit
) {
    if (viewModel.getTopHeadlines().articles.isNotEmpty()) {
        val article = index?.let { viewModel.getTopHeadlines().articles[it] }
        if (article != null) {
            Scaffold(
                topBar = {NewsDetailsTopBar {onBack()}},
                content = { NewsDetailsContent(article)})
        }
    }
}