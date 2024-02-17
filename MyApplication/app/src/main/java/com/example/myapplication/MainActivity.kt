package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearProgressIndicator = findViewById<LinearProgressIndicator>(R.id.linearProgressIndicator)
        val progressTextView = findViewById<TextView>(R.id.progressTextView)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val currentProgress = linearProgressIndicator.progress + 2
            progressTextView.text = currentProgress.toString()
            linearProgressIndicator.setProgress(currentProgress,true)
        }
    }

}