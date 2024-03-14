package com.alif.alifchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.alif.alifchat.messenger.fragment.presentation.ToolBarFragment
import com.alif.alifchat.messenger.fragment.presentation.fragment.ChatDetailFragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChatDetailFragment())
            .commit()
    }

}