package com.swiftpackage.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swiftpackage.fragments.fragment.StartFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container,StartFragment())
            .commit()

    }

}