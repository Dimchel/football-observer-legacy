package com.dimchel.footballobserver

import android.app.Application

class Application : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}