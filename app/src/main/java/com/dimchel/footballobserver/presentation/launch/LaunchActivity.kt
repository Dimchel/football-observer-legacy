package com.dimchel.footballobserver.presentation.launch

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.dimchel.feature_competitions.presentation.CompetitionsActivity
import com.dimchel.footballobserver.R

class LaunchActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, CompetitionsActivity::class.java)
        startActivity(intent)

        finish()
    }
}
