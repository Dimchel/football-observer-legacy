package com.dimchel.footballobserver.data.repos.competition

import com.dimchel.footballobserver.data.mappers.CompetitionMapper
import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.data.repos.competition.models.LeagueModel
import io.reactivex.Single


class CompetitionRepoImpl(private val apiProvider: ApiServiceProvider, private val mapper: CompetitionMapper): CompetitionRepo {

    private var competitionsCashList: List<CompetitionModel> = ArrayList()

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
        return apiProvider.fetchLeague(competitionId)
                .map {
                    scheme -> mapper.mapLeagueSchemeToLeagueModel(scheme)
                }
    }

}