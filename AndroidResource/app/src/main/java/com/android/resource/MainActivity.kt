package com.android.resource

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val imageView = findViewById<ImageView>(R.id.imageView)
//        Glide.with(imageView)
//            .load(R.drawable.ic_launcher_background)
//            .into(imageView)

        val textView = findViewById<TextView>(R.id.textView)
        assets.open("sampe.json").readBytes().toString(Charsets.UTF_8).let {
            textView.text = it
        }

//        resources.openRawResource(R.raw.sampe).readBytes().toString(Charsets.UTF_8).let {
//            textView.text = it
//        }
    }

}