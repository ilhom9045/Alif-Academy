package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.SecondActivity.Companion.DATA
import com.example.myapplication.SecondActivity.Companion.DATA1
import com.example.myapplication.SecondActivity.Companion.PASSWORD
import kotlinx.parcelize.Parcelize
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    val TAG = this::class.java.simpleName

    val button by lazy {
        findViewById<Button>(R.id.button)
    }

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val password = it.data?.getStringExtra(PASSWORD)
            button.text = password
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).dbClass
        if (savedInstanceState != null) {
            Log.d(TAG, "savedInstanceState!=null")
        }
        button.setOnClickListener {
            launcher.launch(Intent(this@MainActivity, SecondActivity::class.java))
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

data class IntentExtra(
    val password: String,
    val login: String
) : Serializable

@Parcelize
data class IntentExtraParsable(
    val password: String,
    val login: String
) : Parcelable
