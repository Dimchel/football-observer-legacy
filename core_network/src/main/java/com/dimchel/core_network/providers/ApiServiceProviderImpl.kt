package com.dimchel.core_network.providers

import com.dimchel.core_network.di.CoreNetworkScope
import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import javax.inject.Inject

@CoreNetworkScope
class ApiServiceProviderImpl @Inject constructor(
    private val apiService: FootballApiService
) : ApiServiceProvider {

    override suspend fun fetchCompetitions(): List<CompetitionScheme> = apiService.getCompetitionsList()

    override suspend fun fetchLeague(competitionId: Long): LeagueScheme = apiService.getCompetitionsList(competitionId)

}