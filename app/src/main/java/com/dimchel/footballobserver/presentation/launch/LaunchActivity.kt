package com.dimchel.footballobserver.presentation.launch

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.presentation.competitions.CompetitionsActivity


class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, CompetitionsActivity::class.java)
        startActivity(intent)

        finish()
    }

}
