package com.alif.dialogs

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog
            .Builder(this)
            .setTitle("Title")
            .setMessage("Message")
            .setCancelable(false)
            .setPositiveButton(
                "Yes"
            ) { dialog, which ->
                dialog?.dismiss()
            }.setNegativeButton("No") { dialog, which -> }
            .create().show()
    }
}