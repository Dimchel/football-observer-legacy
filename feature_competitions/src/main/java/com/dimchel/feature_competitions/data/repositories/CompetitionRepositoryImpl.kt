package com.dimchel.feature_competitions.data.repositories

import com.dimchel.core_network.providers.ApiServiceProvider
import com.dimchel.feature_competitions.data.repositories.mappers.mapToModel
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import com.dimchel.feature_competitions.data.repositories.models.LeagueModel
import com.dimchel.feature_competitions.di.CompetitionScope
import javax.inject.Inject

@CompetitionScope
class CompetitionRepositoryImpl @Inject constructor(
    private val apiProvider: ApiServiceProvider
) : CompetitionRepository {

    private var competitionsCashList: List<CompetitionModel> = ArrayList()
    private var leagueMap: HashMap<Long, LeagueModel> = HashMap()

    override suspend fun getCompetitionsList(): List<CompetitionModel> =
        if (competitionsCashList.isEmpty()) {
            competitionsCashList = apiProvider.fetchCompetitions().map { it.mapToModel() }

            competitionsCashList
        } else {
            competitionsCashList
        }

    override suspend fun getLeagueTable(competitionId: Long): LeagueModel =
        if (!leagueMap.containsKey(competitionId)) {
            leagueMap[competitionId] = apiProvider.fetchLeague(competitionId).mapToModel()

            leagueMap[competitionId]!!
        } else {
            leagueMap[competitionId]!!
        }
}