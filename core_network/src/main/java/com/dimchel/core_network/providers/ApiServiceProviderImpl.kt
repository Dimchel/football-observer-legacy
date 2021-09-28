package com.dimchel.core_network.providers

import com.dimchel.core_architecture.data.BaseApiProvider
import com.dimchel.core_architecture.data.DataResult
import com.dimchel.core_network.di.CoreNetworkScope
import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import javax.inject.Inject

@CoreNetworkScope
class ApiServiceProviderImpl @Inject constructor(
    private val apiService: FootballApiService
) : BaseApiProvider(), ApiServiceProvider {

    override suspend fun fetchCompetitions(): DataResult<List<CompetitionScheme>> =
        getResponse { apiService.getCompetitionsList().competitions }

    override suspend fun fetchLeague(competitionCode: String): DataResult<LeagueScheme> =
        getResponse { apiService.getLeague(competitionCode) }

}