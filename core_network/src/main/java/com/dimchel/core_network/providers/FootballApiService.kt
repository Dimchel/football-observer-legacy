package com.dimchel.core_network.providers

import com.dimchel.core_network.schemes.responses.CompetitionsScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballApiService {

    @GET("v2/competitions")
    suspend fun getCompetitionsList(): CompetitionsScheme

    @GET("v2/competitions/{code}/standings")
    suspend fun getLeague(@Path("code") competitionCode: String): LeagueScheme

}