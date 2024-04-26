package com.alif.newsapplication.view.history.view

import android.view.View
import android.widget.PopupMenu
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.alif.core.view.extention.findViewById
import com.alif.newsapplication.R
import com.alif.newsapplication.core.view.BaseNewsNetworkVMFragment
import com.alif.newsapplication.model.NewsArticlesModel
import com.alif.newsapplication.view.history.vm.HistoryFragmentViewModel
import com.alif.newsapplication.view.home.view.adapter.NewsAdapter
import com.alif.newsapplication.view.home.view.adapter.viewHolder.NewsViewHolder
import com.alif.newsapplication.view.home.vm.NewsResult
import org.koin.androidx.viewmodel.ext.android.viewModel


class HistoryFragment : BaseNewsNetworkVMFragment<NewsResult, HistoryFragmentViewModel>(
    R.layout.fragment_home,
), NewsViewHolder.OnNewsItemClickedListener {

    private val genericAdapter = NewsAdapter(this)

    override val viewModel: HistoryFragmentViewModel by viewModel()

    override fun initView() {
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = genericAdapter
        }
    }

    override fun onInitVMObservers(): HistoryFragmentViewModel.() -> Unit = {
        resultLiveData.observe {
            when (it) {
                is NewsResult.NewArticle -> genericAdapter.submitList(it.articles)
                else -> {}
            }
        }
        loadNews()
    }

    override fun onNewsItemClicked(item: NewsArticlesModel, position: Int) {}
    override fun onLongItemClicked(view: View, item: NewsArticlesModel, position: Int): Boolean {
        viewModel.isFavorite(item).observe { result ->
            val popupMenu = PopupMenu(requireContext(), view)
            popupMenu.inflate(R.menu.favorite_menu)
            popupMenu.menu[0].title = if (result.isFavorite) {
                "Remove Favorite"
            } else {
                "Add Favorite"
            }
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.addFavorite -> {
                        if (result.isFavorite) {
                            viewModel.removeFavorite(item)
                        } else {
                            viewModel.addFavorite(item)
                        }
                        true
                    }

                    else -> false
                }
            }
            popupMenu.show()
        }
        return true
    }

}