package com.dimchel.core

import android.util.Log

private const val APP_TAG: String = "FootballObserver_"

fun flog(tag: String, msg: String) {
    Log.d(APP_TAG + tag, msg)
}

fun flog(tag: String, msg: String, tr: Throwable) {
    Log.d(APP_TAG + tag, msg, tr)
}