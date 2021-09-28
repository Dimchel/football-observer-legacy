package com.dimchel.feature_competitions_api.data.repositories

import com.dimchel.core_architecture.data.DataResult
import com.dimchel.core_architecture.data.mapSuccess
import com.dimchel.core_network.providers.ApiServiceProvider
import com.dimchel.feature_competitions_api.data.mappers.mapToModel
import com.dimchel.feature_competitions_api.data.models.CompetitionModel
import com.dimchel.feature_competitions_api.data.models.LeagueModel
import com.dimchel.feature_competitions_api.di.CompetitionApiScope
import javax.inject.Inject

@CompetitionApiScope
class CompetitionRepositoryImpl @Inject constructor(
    private val apiProvider: ApiServiceProvider
) : CompetitionRepository {

    private var competitionsCashList: List<CompetitionModel> = ArrayList()
    private var leagueMap: HashMap<Long, LeagueModel> = HashMap()

    override suspend fun getCompetitionsList(): DataResult<List<CompetitionModel>> =
        if (competitionsCashList.isEmpty()) {
            apiProvider.fetchCompetitions().mapSuccess { schemes ->
                val models = schemes.map { it.mapToModel() }
                competitionsCashList = models
                models
            }
        } else {
            DataResult.DataSuccess(competitionsCashList)
        }


    override suspend fun getLeagueTable(competitionId: Long): DataResult<LeagueModel> =
        if (!leagueMap.containsKey(competitionId)) {
            apiProvider.fetchLeague(competitionId).mapSuccess { scheme ->
                val model = scheme.mapToModel()
                leagueMap[competitionId] = model
                model
            }
        } else {
            DataResult.DataSuccess(leagueMap[competitionId]!!)
        }
}