package com.alif.newsapplication.view.home.view

import androidx.recyclerview.widget.RecyclerView
import com.alif.core.common.clazz
import com.alif.core.view.extention.findViewById
import com.alif.newsapplication.R
import com.alif.newsapplication.core.view.BaseNewsNetworkVMFragment
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.home.view.adapter.NewsAdapter
import com.alif.newsapplication.view.home.view.adapter.viewHolder.NewsViewHolder
import com.alif.newsapplication.view.home.vm.HomeFragmentViewModel
import com.alif.newsapplication.view.home.vm.NewsResult

class HomeFragment : BaseNewsNetworkVMFragment<NewsResult, HomeFragmentViewModel>(
    R.layout.fragment_home,
    clazz()
), NewsViewHolder.OnNewsItemClickedListener {

    private val genericAdapter = NewsAdapter(this)

    override fun initView() {
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = genericAdapter
        }
    }

    override fun onInitVMObservers(): HomeFragmentViewModel.() -> Unit = {
        resultLiveData.observe {
            when (it) {
                is NewsResult.NewArticle -> genericAdapter.submitList(it.articles)
            }
        }
        loadNews()
    }

    override fun onNewsItemClicked(item: NewsArticlesModel, position: Int) {
        viewModel.insertNews(item)
    }
}