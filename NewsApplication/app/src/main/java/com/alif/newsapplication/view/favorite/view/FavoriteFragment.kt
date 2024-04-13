package com.alif.newsapplication.view.favorite.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alif.core.common.clazz
import com.alif.core.view.extention.findViewById
import com.alif.newsapplication.R
import com.alif.newsapplication.core.view.BaseNewsVMFragment
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.favorite.vm.FavoriteFragmentViewModel
import com.alif.newsapplication.view.home.view.adapter.NewsAdapter
import com.alif.newsapplication.view.home.view.adapter.viewHolder.NewsViewHolder
import com.alif.newsapplication.view.home.vm.NewsResult

class FavoriteFragment : BaseNewsVMFragment<NewsResult, FavoriteFragmentViewModel>(
    R.layout.fragment_home,
    clazz()
), NewsViewHolder.OnNewsItemClickedListener {

    private val genericAdapter = NewsAdapter(this)

    override fun initView() {
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = genericAdapter
        }
    }

    override fun onInitVMObservers(): FavoriteFragmentViewModel.() -> Unit = {
        resultLiveData.observe {
            when (it) {
                is NewsResult.NewArticle -> genericAdapter.submitList(it.articles)
                else -> {}
            }
        }
        loadFavorite()
    }

    override fun onNewsItemClicked(item: NewsArticlesModel, position: Int) {}
    override fun onLongItemClicked(view: View, item: NewsArticlesModel, position: Int): Boolean {
        return false
    }
}