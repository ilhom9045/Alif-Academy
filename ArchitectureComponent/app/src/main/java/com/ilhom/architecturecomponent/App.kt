package com.ilhom.architecturecomponent

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class App:Application(), Application.ActivityLifecycleCallbacks {


    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d(this::class.simpleName, "onActivityCreated")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(this::class.simpleName, "onActivityStarted")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(this::class.simpleName, "onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(this::class.simpleName,"onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(this::class.simpleName,"onActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(this::class.simpleName,"onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(this::class.simpleName,"onActivityDestroyed")
    }
}