package com.example.rssfeed.model.repository

import com.example.rssfeed.model.api.RssWebService
import com.example.rssfeed.model.topHeadlines.TopHeadlines

class NewsListScreenRepository(private val webService: RssWebService = RssWebService()) {
    suspend fun getAllNews(
    ): TopHeadlines {
        return webService.getAllNews()
    }
}