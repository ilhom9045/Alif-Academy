package com.alif.themeandstyle

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

fun <T> T?.ifNull(block: () -> Unit) {
    if (this == null) {
        block.invoke()
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager.adapter = ViewPagerAdapter1(supportFragmentManager, lifecycle)
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = position.toString()
//        }.attach()
    }
}

const val DATA = ""

class MyFragment : Fragment(R.layout.fragment_test) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).apply {
            text = arguments?.getString(DATA)
        }
    }
}

class ViewPagerAdapter1(fragment: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragment, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return MyFragment().apply {
            arguments = bundleOf(DATA to position.toString())
        }
    }

}