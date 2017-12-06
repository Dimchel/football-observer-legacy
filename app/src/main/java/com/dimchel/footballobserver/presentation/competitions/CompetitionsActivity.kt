package com.dimchel.footballobserver.presentation.competitions

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.presentation.league.LeagueActivity
import com.dimchel.footballobserver.presentation.league.LeagueActivity.Companion.BUNDLE_COMPETITION_ID
import kotlinx.android.synthetic.main.activity_competitions.*


class CompetitionsActivity :
        MvpAppCompatActivity(),
        CompetitionsView,
        SimpleOnItemSelectedListener<CompetitionModel> {

    @InjectPresenter
    lateinit var presenter: CompetitionPresenter

    private lateinit var adapter: CompetitionsRvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_competitions)

        initViews()
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        val competitionsRecyclerView = competitions_recyclerview

        competitionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        competitionsRecyclerView.addItemDecoration(decorator)

        adapter = CompetitionsRvAdapter(this)
        competitionsRecyclerView.adapter = adapter
    }

    // ===========================================================
    // CompetitionsView
    // ===========================================================

    override fun showCompetitionsList(competitionsList: List<CompetitionModel>) {
        adapter.setData(competitionsList)
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