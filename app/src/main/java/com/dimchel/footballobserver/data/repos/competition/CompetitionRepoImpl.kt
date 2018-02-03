package com.dimchel.footballobserver.data.repos.competition

import com.dimchel.footballobserver.data.mappers.CompetitionMapper
import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.Single


class CompetitionRepoImpl(
        private val apiProvider: ApiServiceProvider,
        private val mapper: CompetitionMapper)
    : CompetitionRepo {

    private var competitionsCashList: List<CompetitionModel> = ArrayList()
    private var leagueMap: HashMap<Long, LeagueModel> = HashMap()

    override fun getCompetitionsList(): Single<List<CompetitionModel>> {
        return if (competitionsCashList.isEmpty()) {
            apiProvider.fetchCompetitions()
                    .map {
                        list -> mapper.mapCompetitionSchemesListToCompetitionModelsList(list)
                    }.doOnSuccess {
                        list -> run {
                            competitionsCashList = list
                        }
                    }
        } else {
            Single.just(competitionsCashList)
        }
    }

    override fun getLeagueTable(competitionId: Long): Single<LeagueModel> {
        return if (!leagueMap.containsKey(competitionId)) {
            apiProvider.fetchLeague(competitionId)
                    .map {
                        scheme -> mapper.mapLeagueSchemeToLeagueModel(scheme)
                    }.doOnSuccess {
                        list -> run {
                            leagueMap.put(competitionId, list)
                        }
                    }
        } else {
            Single.just(leagueMap[competitionId])
        }
    }

}