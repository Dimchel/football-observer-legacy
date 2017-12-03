package com.dimchel.footballobserver.data.repos.competitions

import com.dimchel.footballobserver.data.mappers.CompetitionMapper
import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import io.reactivex.Single


class CompetitionsRepoImpl(private val apiProvider: ApiServiceProvider, private val mapper: CompetitionMapper): CompetitionsRepo {

    var competitionsCashList: List<CompetitionModel> = ArrayList()

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

}