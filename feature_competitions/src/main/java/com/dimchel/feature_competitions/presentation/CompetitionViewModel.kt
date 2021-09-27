package com.dimchel.feature_competitions.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.core_architecture.data.ProgressData
import com.dimchel.core_architecture.data.mapToProgressData
import com.dimchel.feature_competitions.data.repositories.CompetitionRepository
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class CompetitionViewModel @Inject constructor(
    private val repo: CompetitionRepository
): ViewModel() {

    val competitionsLiveData: MutableLiveData<ProgressData<List<CompetitionModel>>> = MutableLiveData()

    init {
        loadData()
    }

    fun onRetryAction() = loadData()

    fun onCompetitionSelected(competitionModel: CompetitionModel) {

    }

    private fun loadData() {
        viewModelScope.launch {
            competitionsLiveData.value = ProgressData.Loading
            competitionsLiveData.value = repo.getCompetitionsList().mapToProgressData()
        }
    }
}