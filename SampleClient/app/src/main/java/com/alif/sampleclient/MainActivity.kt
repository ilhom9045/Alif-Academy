package com.alif.sampleclient

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<EditText>(R.id.loginEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val button = findViewById<Button>(R.id.button)
        val api = HttpClient.createService(Api::class.java)
        button.setOnClickListener {
            lifecycleScope.launch {
                val response =
                    api.login(
                        LoginModel(
                            login.text.toString(),
                            password.text.toString()
                        )
                    )
            }
        }

    }
}


data class LoginModel(
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String
)

class DefaultResponse

interface Api {

    @POST("/login")
    suspend fun login(@Body body: LoginModel): DefaultResponse

}

object HttpClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build())
            .build()
    }

    fun <T> createService(clazz: Class<T>): T = retrofit.create(clazz)

}