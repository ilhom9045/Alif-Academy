package com.alif.webview

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val webView by lazy {
        findViewById<WebView>(R.id.webView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView.apply {
            settings.javaScriptEnabled = true
            webView.evaluateJavascript("""
                function sum(a,b){
                    return a+b;
                }
                sum(1,2);
            """.trimIndent(),){
                Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
            }

            webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    view?.loadUrl(request?.url.toString())
                    return true
                }

            }

            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView?,
                    url: String?,
                    message: String?,
                    result: JsResult?
                ): Boolean {
                    AlertDialog.Builder(this@MainActivity)
                        .setMessage(message.toString())
                        .setPositiveButton("Yes"
                        ) { dialog, which -> }
                        .create().show()
                    return true
                }
            }

//            loadData("""
//                <html>
//                    <body>
//                        <button type="button", onclick="buttonClick()">Click me</button>
//                    </body>
//                    <script type="text/javascript">
//                        function buttonClick(){
//                           Android.changeStatusBarColor("red");
//                        }
//                    </script>
//                    </html>
//            """.trimIndent(),"text/html","utf-8")

                        loadData("""
                <html>
                    <body>
                        <button type="button", onclick="buttonClick()">Click me</button>
                    </body>
                    <script type="text/javascript">
                        function buttonClick(){
                           alert("Button Clicked"); 
                        }
                    </script>
                    </html>
            """.trimIndent(),"text/html","utf-8")

            webView.addJavascriptInterface(ChangeStatusBar(this@MainActivity),"Android")

        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
            return
        }
        super.onBackPressed()
    }

    class ChangeStatusBar(private val activity: AppCompatActivity) {

        @JavascriptInterface
        fun changeStatusBarColor(hex:String){
            val color = Color.parseColor(hex)
            activity.setStatusBarColor(color)
        }

    }

}

fun Activity.setStatusBarColor(color:Int){
    var flags = window?.decorView?.systemUiVisibility // get current flag
    if (flags != null) {
        if(isColorDark(color)){
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            window?.decorView?.systemUiVisibility = flags
        }else{
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window?.decorView?.systemUiVisibility = flags
        }
    }
    window?.statusBarColor = color
}

fun Activity.isColorDark(color:Int) : Boolean{
    val darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
    return darkness >= 0.5
}