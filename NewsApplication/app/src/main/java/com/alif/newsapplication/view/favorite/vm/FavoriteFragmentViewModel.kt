package com.alif.newsapplication.view.favorite.vm

import com.alif.newsapplication.core.vm.BaseNewsViewModel
import com.alif.newsapplication.model.NewsFavoriteRepository
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.home.vm.NewsResult


class FavoriteFragmentViewModel : BaseNewsViewModel<NewsResult>() {

    private val newsFavoriteRepository = NewsFavoriteRepository.Base()

    fun loadFavorite() {
        launchIO {
            mutableResultLiveData.postValue(NewsResult.NewArticle(newsFavoriteRepository.asyncLoadFavorites()))
        }
    }

    fun removeFavorite(favorite: NewsArticlesModel) {
        launchIO {
            newsFavoriteRepository.asyncRemove(favorite)
            mutableResultLiveData.postValue(NewsResult.NewArticle(newsFavoriteRepository.asyncLoadFavorites()))
        }
    }

}