package com.example.rssfeed.model.article

data class Article(
    val title: String,
    val urlToImage: String?,
    val description: String?,
    val url: String
)