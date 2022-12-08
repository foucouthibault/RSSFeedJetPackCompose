package com.example.rssfeed.model.api

import com.example.rssfeed.BuildConfig
import com.example.rssfeed.model.topHeadlines.TopHeadlines
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

class RssWebService @Inject constructor() {
    private var api: RssApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(RssApi::class.java)
    }

    suspend fun getAllNews(): TopHeadlines {
        return api.getAllNews()
    }

    interface RssApi {
        @GET("/v2/everything?sources=le-monde,lequipe,les-echos,liberation&apiKey=" + BuildConfig.API_KEY)
        suspend fun getAllNews(): TopHeadlines
    }
}