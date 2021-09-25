package com.dimchel.feature_competitions.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dimchel.core_architecture.viewmodels.ViewModelFactory
import com.dimchel.core_architecture.viewmodels.getViewModel
import com.dimchel.feature_competitions.R
import com.dimchel.feature_competitions.di.CompetitionComponent
import com.dimchel.feature_competitions.di.CompetitionDependencyProviderImpl
import javax.inject.Inject

class CompetitionsActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<CompetitionViewModel>

    private lateinit var adapter: CompetitionsRvAdapter

    private lateinit var viewModel: CompetitionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.competitions_activity)

        initViews()

        (CompetitionDependencyProviderImpl.provide(application) as CompetitionComponent).inject(this)

        viewModel = viewModelFactory.getViewModel(this)
        viewModel.competitionsLiveData.observe(this) {
            adapter.setData(it)
        }
    }

    private fun initViews() {
        initRecycler()
    }

    private fun initRecycler() {
        val competitionsRecyclerView = findViewById<RecyclerView>(R.id.competitions_recyclerview)

        competitionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val decorator = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        competitionsRecyclerView.addItemDecoration(decorator)

        adapter = CompetitionsRvAdapter {
            //        presenter.onCompetitionSelected(item)
        }
        competitionsRecyclerView.adapter = adapter
    }

//    override fun showLeagueView(competitionId: Long) {
//        val intent = Intent(this, LeagueActivity::class.java)
//        intent.putExtra(BUNDLE_COMPETITION_ID, competitionId)
//        startActivity(intent)
//    }
}