package com.alif.newsapplication.view.history.view

import androidx.recyclerview.widget.RecyclerView
import com.alif.core.common.clazz
import com.alif.core.view.extention.findViewById
import com.alif.newsapplication.R
import com.alif.newsapplication.core.view.BaseNewsNetworkVMFragment
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.history.vm.HistoryFragmentViewModel
import com.alif.newsapplication.view.home.view.adapter.NewsAdapter
import com.alif.newsapplication.view.home.view.adapter.viewHolder.NewsViewHolder
import com.alif.newsapplication.view.home.vm.NewsResult


class HistoryFragment : BaseNewsNetworkVMFragment<NewsResult, HistoryFragmentViewModel>(
    R.layout.fragment_home,
    clazz()
), NewsViewHolder.OnNewsItemClickedListener {

    private val genericAdapter = NewsAdapter(this)

    override fun initView() {
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = genericAdapter
        }
    }

    override fun onInitVMObservers(): HistoryFragmentViewModel.() -> Unit = {
        resultLiveData.observe {
            when (it) {
                is NewsResult.NewArticle -> genericAdapter.submitList(it.articles)
            }
        }
        loadNews()
    }

    override fun onNewsItemClicked(item: NewsArticlesModel, position: Int) {}
}