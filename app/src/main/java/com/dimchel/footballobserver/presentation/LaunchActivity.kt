package com.dimchel.footballobserver.presentation

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.dimchel.footballobserver.R

class LaunchActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_launch)
    }
}
