package com.dimchel.footballobserver.data.networks.api

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import com.dimchel.footballobserver.data.networks.models.responses.LeagueScheme
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface FootballApiService {

    @GET("competitions")
    fun getCompetitionsList(): Single<List<CompetitionScheme>>

    @GET("competitions/{id}/leagueTable")
    fun getCompetitionsList(@Path("id") competitionId: Long): Single<LeagueScheme>

}