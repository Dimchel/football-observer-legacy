package com.dimchel.footballobserver.presentation.league

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel
import kotlinx.android.synthetic.main.activity_league.*


class LeagueActivity : MvpAppCompatActivity(), LeagueView, SimpleOnItemSelectedListener<CompetitionerModel> {

    companion object {
        val BUNDLE_COMPETITION_ID = "CompetitionsActivity.BUNDLE_COMPETITION_ID"
    }

    lateinit var leagueRecyclerView: RecyclerView
    lateinit var adapter: LeagueRvAdapter

    @InjectPresenter
    lateinit var presenter: LeaguePresenter

    @ProvidePresenter
    fun provideLeaguePresenter(): LeaguePresenter {
        return LeaguePresenter(intent.getLongExtra(BUNDLE_COMPETITION_ID, 0))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_league)

        initViews()
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        leagueRecyclerView = league_league_recyclerview

        leagueRecyclerView.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        leagueRecyclerView.addItemDecoration(decorator)

        adapter = LeagueRvAdapter(this)
        leagueRecyclerView.adapter = adapter
    }

    // ===========================================================
    // LeagueView
    // ===========================================================

    override fun updateTitleView(leagueName: String) {
        supportActionBar?.title = leagueName
    }

    override fun updateMatchdayView(matchday: Int) {

    }

    override fun showStandingList(competitionersList: List<CompetitionerModel>) {
        adapter.setData(competitionersList)

        leagueRecyclerView.visibility = View.VISIBLE
    }

    override fun hideStandingList() {
        leagueRecyclerView.visibility = View.INVISIBLE
    }

    // ===========================================================
    // SimpleOnItemSelectedListener
    // ===========================================================

    override fun onItemSelected(item: CompetitionerModel) {

    }

}