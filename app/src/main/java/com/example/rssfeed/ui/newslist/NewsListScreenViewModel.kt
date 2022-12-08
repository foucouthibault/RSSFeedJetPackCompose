package com.example.rssfeed.ui.newslist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rssfeed.model.repository.NewsListScreenRepository
import com.example.rssfeed.model.topHeadlines.TopHeadlines
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListScreenViewModel @Inject constructor(private val newsListScreenRepository: NewsListScreenRepository) :
    ViewModel() {
    private val topHeadlines = mutableStateOf(TopHeadlines(articles = emptyList()))

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                topHeadlines.value = getAllNews()
            } catch (_: Exception) {
            }
        }
    }

    private suspend fun getAllNews(): TopHeadlines {
        return newsListScreenRepository.getAllNews()
    }

    fun getTopHeadlines(): TopHeadlines {
        return topHeadlines.value
    }
}