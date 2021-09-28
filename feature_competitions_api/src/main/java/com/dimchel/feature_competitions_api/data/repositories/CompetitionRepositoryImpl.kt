package com.dimchel.feature_competitions_api.data.repositories

import com.dimchel.core.flog
import com.dimchel.core_architecture.data.DataResult
import com.dimchel.core_architecture.data.mapSuccess
import com.dimchel.core_network.ApiConstants
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
    private var leagueMap: HashMap<String, LeagueModel> = HashMap()

    override suspend fun getCompetitionsList(): DataResult<List<CompetitionModel>> =
        if (competitionsCashList.isEmpty()) {
            apiProvider.fetchCompetitions().mapSuccess { schemes ->
                flog("schemes: " + schemes.size)
                val models = schemes
                    .filter { ApiConstants.AVAILABLE_COMPETITIONS.contains(it.code) }
                    .map { it.mapToModel() }

                flog("models: " + models.size)

                competitionsCashList = models
                models
            }
        } else {
            DataResult.DataSuccess(competitionsCashList)
        }


    override suspend fun getLeagueTable(competitionCode: String): DataResult<LeagueModel> =
        if (!leagueMap.containsKey(competitionCode)) {
            apiProvider.fetchLeague(competitionCode).mapSuccess { scheme ->
                val model = scheme.mapToModel()
                leagueMap[competitionCode] = model
                model
            }
        } else {
            DataResult.DataSuccess(leagueMap[competitionCode]!!)
        }
}