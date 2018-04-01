package com.dimchel.footballobserver.common

import android.util.Log
import com.dimchel.footballobserver.BuildConfig


class Logger {

    companion object {

        private const val APP_TAG: String = "FootballObserver_"

        fun log(msg: String) {
            if (!BuildConfig.DEBUG) return
            Log.d(APP_TAG, msg)
        }

        fun log(tag: String, msg: String) {
            if (!BuildConfig.DEBUG) return
            Log.d(APP_TAG + tag, msg)
        }

        fun log(tag: String, msg: String, tr: Throwable) {
            if (!BuildConfig.DEBUG) return
            Log.d(APP_TAG + tag, msg, tr)
        }
    }

}