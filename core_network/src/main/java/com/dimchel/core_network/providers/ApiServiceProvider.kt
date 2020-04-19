package com.dimchel.core_network.providers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme


interface ApiServiceProvider {

    suspend fun fetchCompetitions(): List<CompetitionScheme>
    suspend fun fetchLeague(competitionId: Long): LeagueScheme

}