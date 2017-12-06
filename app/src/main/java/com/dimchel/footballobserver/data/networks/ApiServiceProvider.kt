package com.dimchel.footballobserver.data.networks

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.networks.models.responses.LeagueScheme
import io.reactivex.Single


interface ApiServiceProvider {

    fun fetchCompetitions(): Single<List<CompetitionScheme>>
    fun fetchLeague(competitionId: Long): Single<LeagueScheme>

}