package com.example.rssfeed.ui.newslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rssfeed.model.repository.NewsListScreenRepository
import com.example.rssfeed.model.topHeadlines.TopHeadlines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsListScreenViewModel(private val newsListScreenRepository : NewsListScreenRepository = NewsListScreenRepository()): ViewModel() {
    private val topHeadlines = mutableStateOf(TopHeadlines(articles = emptyList()))

    init {
        viewModelScope.launch(Dispatchers.IO) {
            topHeadlines.value = getAllNews()
        }
    }

    private suspend fun getAllNews(): TopHeadlines {
        return newsListScreenRepository.getAllNews()
    }

    fun getTopHeadlines(): TopHeadlines {
        return topHeadlines.value
    }
}