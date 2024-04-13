package com.alif.newsapplication.view.history.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alif.newsapplication.core.vm.BaseNewsViewModel
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.model.NewsFavoriteRepository
import com.alif.newsapplication.model.NewsHistoryRepository
import com.alif.newsapplication.view.home.vm.NewsResult

class HistoryFragmentViewModel : BaseNewsViewModel<NewsResult>() {

    private val newsHistoryRepository = NewsHistoryRepository.Base()
    private val newsFavoriteRepository = NewsFavoriteRepository.Base()

    fun loadNews() {
        launchIO {
            mutableResultLiveData.postValue(NewsResult.NewArticle(newsHistoryRepository.loadNewsHistory()))
        }
    }

    fun isFavorite(item: NewsArticlesModel):LiveData<NewsResult.IsNewsFavorite> {
        val mutableLiveData = MutableLiveData<NewsResult.IsNewsFavorite>()
        launchIO {
            mutableLiveData.postValue(
                NewsResult.IsNewsFavorite(
                    newsFavoriteRepository.asyncIsFavorite(
                        item
                    )
                )
            )
        }
        return mutableLiveData
    }

    fun removeFavorite(item: NewsArticlesModel) {
        launchIO {
            newsFavoriteRepository.asyncRemove(item)
        }
    }

    fun addFavorite(item: NewsArticlesModel) {
        launchIO {
            newsFavoriteRepository.asyncAddFavorite(item)
        }
    }

}