package com.dimchel.feature_competitions.data.repositories

import com.dimchel.core_architecture.data.DataResult
import com.dimchel.core_architecture.repository.Repository
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import com.dimchel.feature_competitions.data.repositories.models.LeagueModel

interface CompetitionRepository : Repository {

    suspend fun getCompetitionsList(): DataResult<List<CompetitionModel>>
    suspend fun getLeagueTable(competitionId: Long): DataResult<LeagueModel>

}