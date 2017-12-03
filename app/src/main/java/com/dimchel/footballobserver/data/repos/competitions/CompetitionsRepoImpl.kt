package com.dimchel.footballobserver.data.repos.competitions

import com.dimchel.footballobserver.data.networks.ApiServiceProvider
import com.dimchel.footballobserver.data.networks.NetworkError
import com.dimchel.footballobserver.data.networks.OnNetworkDataListener
import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.repos.OnRepoDataListener


class CompetitionsRepoImpl(private val apiProvider: ApiServiceProvider): CompetitionsRepo {

    var competitionsCashList: List<CompetitionScheme> = ArrayList()

    override fun getCompetitionsList(listener: OnRepoDataListener<List<CompetitionScheme>>) {

        if (competitionsCashList.isEmpty()) {
            apiProvider.fetchCompetitions(object : OnNetworkDataListener<List<CompetitionScheme>> {
                override fun onResult(result: List<CompetitionScheme>) {
                    competitionsCashList = result

                    listener.onResult(competitionsCashList)
                }

                override fun onFailure(error: NetworkError) {
                    listener.onFailure(error)
                }
            })

        } else {
            listener.onResult(competitionsCashList)
        }
    }

}