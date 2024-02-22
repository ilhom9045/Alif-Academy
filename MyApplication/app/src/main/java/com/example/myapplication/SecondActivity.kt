package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(R.layout.second_activity) {

    val TAG = this::class.java.simpleName

    companion object {
        const val PASSWORD = "password"
        const val DATA = "data"
        const val DATA1 = "data1"
        var sample:String?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val editText = findViewById<EditText>(R.id.textView)

        findViewById<Button>(R.id.seconActivityButton).setOnClickListener {
            setResult(RESULT_OK, Intent().apply {
                putExtra(PASSWORD, editText.text.toString())
            })
            println(sample)
            sample = null
            onBackPressed()
        }
        if (savedInstanceState != null) {
            Log.d(TAG, "savedInstanceState!=null")
        }
        Log.d(TAG, "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onLowMemory() {
        super.onLowMemory()

    }

}