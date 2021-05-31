package com.example.alfioesiea3a.presentation

import android.app.Application
import android.content.Context

class pokeApplication : Application(){
    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}