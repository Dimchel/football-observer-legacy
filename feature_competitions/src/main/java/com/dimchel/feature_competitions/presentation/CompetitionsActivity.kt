package com.dimchel.feature_competitions.presentation

import android.app.Activity
import android.os.Bundle
import com.dimchel.feature_competitions.R


class CompetitionsActivity : Activity() {
//        MvpAppCompatActivity(),
//        CompetitionsView,
//        SimpleOnItemSelectedListener<com.dimchel.feature_competitions.repositories.models.CompetitionModel> {
//
//    @InjectPresenter
//    lateinit var presenter: com.dimchel.feature_competitions.presentation.CompetitionPresenter
//
//    private lateinit var adapter: CompetitionsRvAdapter
//

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.competitions_activity)

//        initViews()
    }
//
//    private fun initViews() {
//        initRecycler()
//    }
//
//    private fun initRecycler() {
//        val competitionsRecyclerView = competitions_recyclerview
//
//        competitionsRecyclerView.layoutManager = LinearLayoutManager(this)
//
//        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
//        competitionsRecyclerView.addItemDecoration(decorator)
//
//        adapter = CompetitionsRvAdapter(this)
//        competitionsRecyclerView.adapter = adapter
//    }
//
//    // ===========================================================
//    // CompetitionsView
//    // ===========================================================
//
//    override fun showCompetitionsList(competitionsList: List<com.dimchel.feature_competitions.repositories.models.CompetitionModel>) {
//        adapter.setData(competitionsList)
//    }
//
//    override fun showLeagueView(competitionId: Long) {
//        val intent = Intent(this, LeagueActivity::class.java)
//        intent.putExtra(BUNDLE_COMPETITION_ID, competitionId)
//        startActivity(intent)
//    }
//
//    // ===========================================================
//    // SimpleOnItemSelectedListener
//    // ===========================================================
//
//    override fun onItemSelected(item: com.dimchel.feature_competitions.repositories.models.CompetitionModel) {
//        presenter.onCompetitionSelected(item)
//    }
//
}