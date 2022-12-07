package com.example.rssfeed.model.repository

import com.example.rssfeed.model.api.RssWebService
import com.example.rssfeed.model.topHeadlines.TopHeadlines
import javax.inject.Inject

class NewsListScreenRepository @Inject constructor(private val webService: RssWebService) {
    suspend fun getAllNews(
    ): TopHeadlines {
        return webService.getAllNews()
    }
}