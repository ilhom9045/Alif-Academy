package com.alif.broadcastreciever.view

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alif.broadcastreciever.R

class MainActivity : AppCompatActivity() {

    private val batteryBroadCastReceiver = BatteryBroadCastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).apply {
            batteryBroadCastReceiver.setListener(object :
                BatteryBroadCastReceiver.BatteryBroadCastReceiverListener {

                override fun onBatteryChanged(batteryLevel: Int) {
                    text = batteryLevel.toString()
                }

                override fun onBatteryLow(low: Boolean) {
                    setBackgroundColor(if (low) Color.RED else Color.GREEN)
                }

            })
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(batteryBroadCastReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onPause() {
        super.onPause()
        batteryBroadCastReceiver.setListener(null)
        unregisterReceiver(batteryBroadCastReceiver)
    }


}