package com.ilhom.architecturecomponent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this)[MyViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.secondActivity).apply {
            setOnClickListener {
                viewModel.increment()
            }
        }

        viewModel.counterLiveData.observe(this) {
            textView.text = it.toString()
        }
    }


}
