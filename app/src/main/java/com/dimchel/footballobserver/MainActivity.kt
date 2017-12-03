package com.dimchel.footballobserver

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dimchel.footballobserver.data.repos.competitions.CompetitionsRepo
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repo: CompetitionsRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Application.instance.initCompetitionComponent().inject(this)

        repo.log()
    }

}
