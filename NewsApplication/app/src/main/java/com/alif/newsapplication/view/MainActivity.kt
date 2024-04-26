package com.alif.newsapplication.view

import android.view.MenuItem
import androidx.core.view.get
import com.alif.core.view.BaseActivity
import com.alif.core.view.extention.transaction
import com.alif.newsapplication.R
import com.alif.newsapplication.view.dictionary.view.DictionaryFragment
import com.alif.newsapplication.view.favorite.view.FavoriteFragment
import com.alif.newsapplication.view.history.view.HistoryFragment
import com.alif.newsapplication.view.home.view.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope
import kotlin.properties.Delegates

class MainActivity : BaseActivity(R.layout.activity_main),
    NavigationBarView.OnItemSelectedListener,AndroidScopeComponent {

    private var bottomNavigationView: BottomNavigationView by Delegates.notNull()

    override fun initView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        val menuItem = bottomNavigationView.menu[0]
        menuItem.isCheckable = true
        onNavigationItemSelected(menuItem)
    }

    override fun initListener() {
        super.initListener()
        bottomNavigationView.setOnItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menu: MenuItem): Boolean {
        return when (menu.itemId) {

            R.id.home -> {
                transaction(R.id.fragmentContainer, HomeFragment())
                true
            }

            R.id.history -> {
                transaction(R.id.fragmentContainer, HistoryFragment())
                true
            }

            R.id.favorite -> {
                transaction(R.id.fragmentContainer, FavoriteFragment())
                true
            }

            R.id.dictionary -> {
                transaction(R.id.fragmentContainer, DictionaryFragment())
                true
            }

            else -> false
        }
    }

    override val scope: Scope by activityScope()

}

