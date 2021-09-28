package com.dimchel.feature_league.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.core_architecture.data.ProgressData
import com.dimchel.core_architecture.data.mapToProgressData
import com.dimchel.feature_competitions_api.data.models.LeagueModel
import com.dimchel.feature_competitions_api.data.repositories.CompetitionRepository
import com.dimchel.feature_league.presentation.list.LeagueListModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueViewModel @Inject constructor(
    private val repo: CompetitionRepository,
) : ViewModel() {

    val leagueLiveData: MutableLiveData<ProgressData<List<LeagueListModel>>> = MutableLiveData()

    private lateinit var leagueCode: String

    fun onReceiveParams(leagueCode: String) {
        this.leagueCode = leagueCode

        loadData()
    }

    fun onRetryAction() = loadData()

    private fun loadData() {
        viewModelScope.launch {
            leagueLiveData.value = ProgressData.Loading
            leagueLiveData.value = repo.getLeagueTable(leagueCode).mapToProgressData {
                generateContentList(it)
            }
        }
    }

    private fun generateContentList(leagueModel: LeagueModel): List<LeagueListModel> =
        mutableListOf<LeagueListModel>().apply {
            add(LeagueListModel.HeaderListModel)
            addAll(leagueModel.standings.map { LeagueListModel.CompetitorListModel(it) })
        }
}