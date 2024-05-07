package com.alif.broadcastreciever.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BatteryBroadCastReceiver : BroadcastReceiver() {

    private val TAG = BatteryBroadCastReceiver::class.java.simpleName

    private var batteryBroadCastReceiverListener: BatteryBroadCastReceiverListener? = null

    fun setListener(listener: BatteryBroadCastReceiverListener?) {
        this.batteryBroadCastReceiverListener = listener
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val isBatteryLow = intent?.getBooleanExtra("battery_low", false)!!
        val level = intent.getIntExtra("level", -1)!!
        batteryBroadCastReceiverListener?.onBatteryChanged(level)
        batteryBroadCastReceiverListener?.onBatteryLow(isBatteryLow)
    }

    interface BatteryBroadCastReceiverListener {

        fun onBatteryChanged(batteryLevel: Int)

        fun onBatteryLow(low: Boolean)

    }

}