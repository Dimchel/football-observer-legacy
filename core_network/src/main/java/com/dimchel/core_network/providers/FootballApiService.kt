package com.dimchel.core_network.providers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.CompetitionsScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApiService {

    @GET("competitions")
    suspend fun getCompetitionsList(): CompetitionsScheme

    @GET("competitions/{id}/leagueTable")
    suspend fun getCompetitionsList(@Path("id") competitionId: Long): LeagueScheme

}