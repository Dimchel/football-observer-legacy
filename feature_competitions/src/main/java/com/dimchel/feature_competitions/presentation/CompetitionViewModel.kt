package com.dimchel.feature_competitions.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.feature_competitions.data.repositories.CompetitionRepository
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CompetitionViewModel @Inject constructor(
    private val repo: CompetitionRepository
): ViewModel() {

    val competitionsLiveData: MutableLiveData<List<CompetitionModel>> = MutableLiveData()

    init {
        viewModelScope.launch {
            competitionsLiveData.value = repo.getCompetitionsList()
        }
    }

//    fun onCompetitionSelected(competitionModel: CompetitionModel) {
//        viewState.showLeagueView(competitionModel.id)
//    }

    // ===========================================================
    // SingleObserver
    // ===========================================================

//    override fun onSuccess(data: List<CompetitionModel>) {
//        viewState.showCompetitionsList(data)
//    }

//    override fun onError(e: Throwable) {
//
//    }
}