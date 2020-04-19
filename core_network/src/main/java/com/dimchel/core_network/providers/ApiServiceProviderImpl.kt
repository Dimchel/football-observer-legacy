package com.dimchel.core_network.providers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme

class ApiServiceProviderImpl(private val apiService: FootballApiService) : ApiServiceProvider {

    override suspend fun fetchCompetitions(): List<CompetitionScheme> = apiService.getCompetitionsList()

    override suspend fun fetchLeague(competitionId: Long): LeagueScheme = apiService.getCompetitionsList(competitionId)

}