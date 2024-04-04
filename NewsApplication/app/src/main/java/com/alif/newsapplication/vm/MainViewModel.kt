package com.alif.newsapplication.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alif.core.vm.BaseViewModel
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.model.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:BaseViewModel() {


    private val mutableLiveData = MutableLiveData<List<NewsArticlesModel>>()
    val liveData:LiveData<List<NewsArticlesModel>> = mutableLiveData

    protected val repository = NewsRepository.Base()


    fun loadNews(){
        viewModelScope.launch(Dispatchers.IO) {
            mutableLiveData.postValue(repository.getNews())
        }
    }

}