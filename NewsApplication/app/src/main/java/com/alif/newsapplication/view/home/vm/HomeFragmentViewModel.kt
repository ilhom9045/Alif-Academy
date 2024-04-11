package com.alif.newsapplication.view.home.vm

import com.alif.newsapplication.core.vm.BaseNewsViewModel
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.model.NewsRepository
import com.alif.newsapplication.model.db.NewsHistoryRepository
import kotlinx.coroutines.runBlocking

sealed class NewsResult {
    data class NewArticle(val articles: List<NewsArticlesModel>) : NewsResult()
}

class HomeFragmentViewModel : BaseNewsViewModel<NewsResult>() {

    private val repository = NewsRepository.Base()
    private val newsHistoryRepository = NewsHistoryRepository.Base()
    fun loadNews() {
        launchIO {
            mutableResultLiveData.postValue(NewsResult.NewArticle(repository.asyncLoadNews()))
        }
    }

    fun insertNews(newsArticle: NewsArticlesModel) {
        launchIO {
            newsHistoryRepository.insertNewsArticle(newsArticle)
        }
    }
}