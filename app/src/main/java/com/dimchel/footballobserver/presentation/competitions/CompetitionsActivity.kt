package com.dimchel.footballobserver.presentation.competitions

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.presentation.league.LeagueActivity
import com.dimchel.footballobserver.presentation.league.LeagueActivity.Companion.BUNDLE_COMPETITION_ID


class CompetitionsActivity :
        MvpAppCompatActivity(),
        CompetitionsView,
        SimpleOnItemSelectedListener<CompetitionModel> {

    private lateinit var progressView: View

    private lateinit var competitionsRecyclerView: RecyclerView
    private lateinit var adapter: CompetitionsRvAdapter

    @InjectPresenter
    lateinit var presenter: CompetitionPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_competitions)

        initViews()
    }

    private fun initViews() {
        progressView = findViewById<View>(R.id.competitions_progressbar)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        competitionsRecyclerView = findViewById<RecyclerView>(R.id.competitions_recyclerview)

        competitionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        competitionsRecyclerView.addItemDecoration(decorator)

        adapter = CompetitionsRvAdapter(this)
        competitionsRecyclerView.adapter = adapter
    }

    // ===========================================================
    // CompetitionsView
    // ===========================================================

    override fun showCompetitionsListView(show: Boolean) {
        if (show) {
            competitionsRecyclerView.visibility = View.VISIBLE
        } else {
            competitionsRecyclerView.visibility = View.INVISIBLE
        }
    }

    override fun updateCompetitionsListView(competitionsList: List<CompetitionModel>) {
        adapter.setData(competitionsList)
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressView.visibility = View.VISIBLE
        } else {
            progressView.visibility = View.INVISIBLE
        }
    }

    override fun showLeagueView(competitionId: Long) {
        val intent = Intent(this, LeagueActivity::class.java)
        intent.putExtra(BUNDLE_COMPETITION_ID, competitionId)
        startActivity(intent)
    }

    // ===========================================================
    // SimpleOnItemSelectedListener
    // ===========================================================

    override fun onItemSelected(item: CompetitionModel) {
        presenter.onCompetitionSelected(item)
    }

}