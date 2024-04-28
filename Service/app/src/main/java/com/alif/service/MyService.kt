package com.alif.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import kotlin.concurrent.thread

class MyService : Service() {

    private val TAG = this::class.java.simpleName
    private val CHANNEL_ID = "mychannel"
    private val NOTIFICATION_ID = 1

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate ${Thread.currentThread().name}")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand ${Thread.currentThread().name}")
        startForeground(NOTIFICATION_ID, showNotification(0))
        thread {
            repeat(10) {
                Thread.sleep(500)
                notificationManager().notify(NOTIFICATION_ID, showNotification(it * 10))
            }
            stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun showNotification(progress: Int): Notification {
        val notification = NotificationCompat
            .Builder(this, CHANNEL_ID)
            .setContentTitle("Content Title")
            .setContentText("Content Text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setLargeIcon(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_launcher_foreground
                )?.toBitmap()
            )
            .setProgress(100, progress, false)
            .setContentIntent(
                PendingIntent.getActivity(
                    this, 0,
                    Intent(
                        this.applicationContext,
                        MainActivity::class.java
                    ), PendingIntent.FLAG_IMMUTABLE
                )
            )
            .build()
        return notification
    }

    private fun notificationManager(): NotificationManager {
        return getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun notificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager().createNotificationChannel(channel)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy ${Thread.currentThread().name}")
    }

    private val binder = LocalBinder()

    override fun onBind(intent: Intent?): IBinder = binder

    fun sum(a: Int, b: Int): Int = a + b

    inner class LocalBinder : Binder() {



        fun service(): MyService = this@MyService

    }

}