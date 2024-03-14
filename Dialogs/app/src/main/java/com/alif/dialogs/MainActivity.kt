package com.alif.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
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

        val view =
            LayoutInflater.from(this)
                .inflate(R.layout.alert_dialog, window.decorView as ViewGroup, false)
        val dialog = AlertDialog
            .Builder(this)
            .setView(view)
            .setCancelable(false)
            .create().apply {
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }

        view.findViewById<TextView>(R.id.canselTextView).setOnClickListener {
            dialog.dismiss()
        }
        view.findViewById<TextView>(R.id.deleteTextView).setOnClickListener {
            //
            dialog.dismiss()
        }


        dialog.show()
    }
}