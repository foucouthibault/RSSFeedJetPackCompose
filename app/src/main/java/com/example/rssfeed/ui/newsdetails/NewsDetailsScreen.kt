package com.example.rssfeed.ui.newsdetails

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rssfeed.ui.newslist.NewsListScreenViewModel

@Composable
fun NewsDetailsScreen(
    index: Int?,
    viewModel: NewsListScreenViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    if (viewModel.getTopHeadlines().articles.isNotEmpty()) {
        val article = index?.let { viewModel.getTopHeadlines().articles[it] }
        if (article != null) {
            Scaffold(
                topBar = { NewsDetailsTopBar(onBack = onBack) },
                content = { NewsDetailsContent(article) })
        }
    }
}