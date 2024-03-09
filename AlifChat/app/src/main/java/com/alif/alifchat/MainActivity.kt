package com.alif.alifchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alif.alifchat.messenger.fragment.presentation.fragment.ChatDetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChatDetailFragment())
            .commit()
    }

}