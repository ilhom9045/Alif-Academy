package com.alif.newsapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.alif.core.common.type
import com.alif.core.view.BaseActivity
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val json = """[{
  "login": "Login",
  "name": "Name",
  "age": 1,
  "sum": 1.0,
  "is_active": true,
  "accounts": [
    false,
    true,
    false,
    true
  ],
  "primary_account": {
    "id": "uuid",
    "sum": 200.0,
    "iso": "RUB"
  }
}]"""
        val gson = Gson()

        findViewById<TextView>(R.id.textView).apply {
            setOnClickListener {
                val parsedJson =
                    gson.fromJson<ArrayList<PersonModel>>(json, type<ArrayList<PersonModel>>())
                Log.d(this@MainActivity::class.java.simpleName, parsedJson.toString())
                text = parsedJson.first().primaryAccount.sum.toString()
                lifecycleScope.launch {
                    delay(5000)
                    text = gson.toJson(parsedJson)
                }
            }
        }
    }

    data class PersonModel(
        @SerializedName("login")
        val login: String,
        @SerializedName("password")
        val name: String,
        @SerializedName("age")
        val age: Int,
        @SerializedName("sum")
        val sum: Double,
        @SerializedName("is_active")
        val isActive: Boolean,
        @SerializedName("accounts")
        val accounts: List<Boolean>?,
        @SerializedName("primary_account")
        val primaryAccount: AccountModel
    ) {
        data class AccountModel(
            @SerializedName("id")
            val id: String,
            @SerializedName("sum")
            val sum: Double,
            @SerializedName("iso")
            val iso: String
        )
    }
}

