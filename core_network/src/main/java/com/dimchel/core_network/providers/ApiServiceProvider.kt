package com.dimchel.core_network.providers

import com.dimchel.core_architecture.data.DataResult
import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme


interface ApiServiceProvider {

    suspend fun fetchCompetitions(): DataResult<List<CompetitionScheme>>
    suspend fun fetchLeague(competitionCode: String): DataResult<LeagueScheme>

}