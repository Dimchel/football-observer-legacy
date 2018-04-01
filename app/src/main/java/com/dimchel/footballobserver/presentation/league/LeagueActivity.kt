package com.dimchel.footballobserver.presentation.league

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.dimchel.footballobserver.Application
import com.dimchel.footballobserver.R
import com.dimchel.footballobserver.common.simpleclasses.SimpleOnItemSelectedListener
import com.dimchel.footballobserver.data.managers.IconManager
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionerModel
import javax.inject.Inject


class LeagueActivity :
        MvpAppCompatActivity(),
        LeagueView,
        SimpleOnItemSelectedListener<CompetitionerModel> {

    companion object {
        const val TAG_LEAGUE_ACTIVITY = "LeagueActivity.TAG_LEAGUE_ACTIVITY"
        const val BUNDLE_COMPETITION_ID = "LeagueActivity.BUNDLE_COMPETITION_ID"
    }

    private lateinit var progressView: View

    private lateinit var leagueRecyclerView: RecyclerView
    private lateinit var adapter: LeagueRvAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: LeaguePresenter

    @ProvidePresenter
    fun providePresenter(): LeaguePresenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Application.instance.getDiManager().getLeagueComponent(TAG_LEAGUE_ACTIVITY, intent.getLongExtra(BUNDLE_COMPETITION_ID, 0)).inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_league)

        initActionBar()

        initViews()
    }

    private fun initActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViews() {
        progressView = findViewById(R.id.league_progressbar)

        initRecycler()
    }

    private fun initRecycler() {
        leagueRecyclerView = findViewById(R.id.league_league_recyclerview)

        leagueRecyclerView.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        leagueRecyclerView.addItemDecoration(decorator)

        adapter = LeagueRvAdapter(IconManager(),this)
        leagueRecyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        if (isFinishing) {
            Application.instance.getDiManager().releaseLeagueComponent(TAG_LEAGUE_ACTIVITY)
        }

        super.onDestroy()
    }

    // ===========================================================
    // LeagueView
    // ===========================================================

    override fun updateTitleView(leagueName: String) {
        supportActionBar?.title = leagueName
    }

    override fun updateMatchdayView(matchday: Int) {

    }

    override fun showStandingListView(show: Boolean) {
        if (show) {
            leagueRecyclerView.visibility = View.VISIBLE
        } else {
            leagueRecyclerView.visibility = View.INVISIBLE
        }
    }

    override fun updateStandingListView(competitionersList: List<CompetitionerModel>) {
        adapter.setData(competitionersList)
    }

    override fun showProgressView(show: Boolean) {
        if (show) {
            progressView.visibility = View.VISIBLE
        } else {
            progressView.visibility = View.INVISIBLE
        }
    }

    // ===========================================================
    // SimpleOnItemSelectedListener
    // ===========================================================

    override fun onItemSelected(item: CompetitionerModel) {

    }

}