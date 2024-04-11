package com.alif.newsapplication.model


import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("articles")
    val articles: List<NewsArticlesModel>
)

data class NewsArticlesModel(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("content")
    val content: String = "",
    @SerializedName("description")
    val description: String,
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: Source? = null,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String
) {
    data class Source(
        @SerializedName("name")
        val name: String
    )
}