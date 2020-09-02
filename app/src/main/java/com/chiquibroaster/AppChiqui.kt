package com.chiquibroaster

import android.app.Application
import android.content.Context

class AppChiqui: Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context =applicationContext


    }

}
