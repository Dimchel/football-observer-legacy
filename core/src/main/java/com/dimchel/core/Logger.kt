package com.dimchel.core

import android.util.Log

private const val APP_TAG: String = "FootballObserver_"
private const val DEBUG_TAG: String = "debug"

fun flog(msg: String) {
    Log.d(APP_TAG + DEBUG_TAG, msg)
}

fun flog(msg: String, tr: Throwable) {
    Log.d(APP_TAG + DEBUG_TAG, msg, tr)
}