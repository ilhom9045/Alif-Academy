package com.alif.newsapplication.view.history.vm

import com.alif.newsapplication.core.vm.BaseNewsViewModel
import com.alif.newsapplication.model.db.NewsHistoryRepository
import com.alif.newsapplication.view.home.vm.NewsResult

class HistoryFragmentViewModel : BaseNewsViewModel<NewsResult>() {

    private val newsHistoryRepository = NewsHistoryRepository.Base()

    fun loadNews() {
        launchIO {
            mutableResultLiveData.postValue(NewsResult.NewArticle(newsHistoryRepository.loadNewsHistory()))
        }
    }

}