package com.alif.newsapplication.view.home.vm

import com.alif.newsapplication.core.vm.BaseNewsViewModel
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.model.NewsRepository
import com.alif.newsapplication.model.NewsHistoryRepository

sealed class NewsResult {
    data class NewArticle(val articles: List<NewsArticlesModel>) : NewsResult()

    data class IsNewsFavorite(val isFavorite: Boolean) : NewsResult()

}

class HomeFragmentViewModel(
    private val repository:NewsRepository,
    private val newsHistoryRepository:NewsHistoryRepository
) : BaseNewsViewModel<NewsResult>() {
    fun loadNews() {
        launchUI {
            mutableResultLiveData.postValue(NewsResult.NewArticle(repository.asyncLoadNews()))
        }
    }

    fun insertNews(newsArticle: NewsArticlesModel) {
        launchIO {
            newsHistoryRepository.insertNewsArticle(newsArticle)
        }
    }
}