package com.dimchel.footballobserver.data.networks.api

import com.dimchel.footballobserver.data.networks.models.responses.CompetitionScheme
import retrofit2.Call
import retrofit2.http.GET


interface FootballApiService {

    @GET("competitions")
    fun getCompetitionsList(): Call<List<CompetitionScheme>>

}