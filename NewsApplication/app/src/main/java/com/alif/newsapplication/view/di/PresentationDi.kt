package com.alif.newsapplication.view.di

import com.alif.newsapplication.view.favorite.vm.FavoriteFragmentViewModel
import com.alif.newsapplication.view.history.vm.HistoryFragmentViewModel
import com.alif.newsapplication.view.home.view.HomeFragment
import com.alif.newsapplication.view.home.vm.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        HomeFragmentViewModel(get(), get())
    }
    viewModel {
        HistoryFragmentViewModel(get(), get())
    }
    viewModel {
        FavoriteFragmentViewModel(get())
    }
}