package com.alif.toolbarandmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

class SecondFragment : Fragment(R.layout.fragment_second_toolbar), MenuProvider {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val appCompatActivity = requireActivity() as AppCompatActivity
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        appCompatActivity.setSupportActionBar(toolbar)
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.supportActionBar?.setDisplayShowHomeEnabled(true)
        requireActivity().addMenuProvider(this,viewLifecycleOwner,Lifecycle.State.CREATED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.second_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
       return true
    }
}