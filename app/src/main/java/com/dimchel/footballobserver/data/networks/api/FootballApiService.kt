package com.dimchel.footballobserver.data.networks.api

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import io.reactivex.Single
import retrofit2.http.GET


interface FootballApiService {

    @GET("competitions")
    fun getCompetitionsList(): Single<List<CompetitionScheme>>

}