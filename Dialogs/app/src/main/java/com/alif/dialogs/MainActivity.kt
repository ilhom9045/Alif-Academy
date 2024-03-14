package com.alif.dialogs

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                snackBack(it)
            }
            setOnLongClickListener {
                popupMenu(it)
                true
            }
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

        dialog.setOnDismissListener {
            Toast.makeText(this, "setOnDismissListener", Toast.LENGTH_SHORT).show()
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

    private fun showProgressDialog() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Title")
        progressDialog.setMessage("Messege")
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.max = 1000
        progressDialog.setCancelable(false)
        CoroutineScope(SupervisorJob() + Dispatchers.Default).launch {
            repeat(1000) {
                delay(100)
                launch(Dispatchers.Main) {
                    progressDialog.secondaryProgress = progressDialog.secondaryProgress + 20
                    progressDialog.progress = progressDialog.progress + 10
                }
            }
        }
        progressDialog.show()
    }

    private fun datePicker() {
        val datePicker = DatePickerDialog(this)
        datePicker.updateDate(2025, 11, 13)
        datePicker.setOnDateSetListener { view, year, month, dayOfMonth ->
            Toast.makeText(
                this,
                "year = $year month = $month day = $dayOfMonth",
                Toast.LENGTH_SHORT
            ).show()
        }
        datePicker.show()
    }

    private fun bottomSheetDialog() {
        val customBottomSheetDialogFragment = CustomBottomSheetDialogFragment()
        customBottomSheetDialogFragment.show(supportFragmentManager, null)
    }

    private fun dialogFragment() {
        val customBottomSheetDialogFragment = CustomDialogFragment()
        customBottomSheetDialogFragment.show(supportFragmentManager, null)
    }

    private fun popupMenu(view: View) {
        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.popup_menu)
        popup.show()
    }

    fun snackBack(view: View) {
        val snackbar = Snackbar.make(this, view, "SnackBar", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

}